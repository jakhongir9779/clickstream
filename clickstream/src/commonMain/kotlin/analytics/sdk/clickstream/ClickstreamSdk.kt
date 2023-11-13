package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickStreamAnalyticsApiImpl
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.DataForPeriodicJob
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.clickstream.exposure.ExposureExperimentsApi
import analytics.sdk.clickstream.exposure.ExposureExperimentsImpl
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGatewayImpl
import analytics.sdk.clickstream.mappers.MapEventToDatabaseEntity
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.database.ClickstreamDatabase
import analytics.sdk.database.gateway.LocalEventsGateway
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.platform.properties.EventPropertiesDelegate
import analytics.sdk.properties.PropertiesProvider
import analytics.sdk.properties.mergePropertiesWithDefault
import analytics.sdk.properties.user.default.UserInstallIdProperty
import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.plugin
import io.ktor.client.request.header
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.Url
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlin.properties.Delegates

object ClickstreamSdk {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "ClickStreamSdk" }
    }

    private val coroutineScope = CoroutineScope(
        SupervisorJob() + Dispatchers.IO + coroutineExceptionHandler,
    )

    private var clickStreamConfig: ClickstreamConfig by Delegates.notNull()
    private var analyticsJobScheduler: AnalyticsJobScheduler by Delegates.notNull()

    private var database: ClickstreamDatabase by Delegates.notNull()
    private var sender: AnalyticsEventSender by Delegates.notNull()
    private var localEventsGateway: LocalEventsGateway by Delegates.notNull()

    private var api: ClickstreamAnalyticsApi by Delegates.notNull()
    private var remoteGateway: ClickstreamRemoteGateway by Delegates.notNull()

    private var exposureExperimentsApi: ExposureExperimentsApi by Delegates.notNull()

    // ORDER MATTERS
    // DO NOT CHANGE
    fun initialize(
        url: String,
        dependencies: PlatformDependencies,
        propertiesProvider: PropertiesProvider?,
        clickStreamConfig: ClickstreamConfig = ClickstreamConfig(),
        requestHeaders: Map<String, () -> String>,
        analyticsJobScheduler: AnalyticsJobScheduler
    ) {
        if (dependencies.utils.initAllowed().not()) return

        this.clickStreamConfig = clickStreamConfig
        this.analyticsJobScheduler = analyticsJobScheduler

        database = ClickstreamDatabase(dependencies.databaseDriverFactory)
        localEventsGateway = database.queries()

        val defaultPropertiesProvider = mergePropertiesWithDefault(dependencies, propertiesProvider)
        val eventPropertiesDelegate = EventPropertiesDelegate(dependencies)

        sender = createAnalyticsClickStreamSender(
            localEventsGateway, createMapEventToDatabaseEntity(
                dependencies,
                defaultPropertiesProvider,
                eventPropertiesDelegate,
            )
        )

        // TODO: check, that logging working only on debug
        /*
        if (isDebug) {
            Timber.plant(Timber.DebugTree())
        }
        */

        api = ClickStreamAnalyticsApiImpl(buildCioHttpClient(requestHeaders, url))
        createGrowthExposure(defaultPropertiesProvider)
        remoteGateway = ClickstreamRemoteGatewayImpl(api)

        dependencies.utils.subscribeOnSessionUpdate(eventPropertiesDelegate)
    }

    fun getDataForWorker() =
        DataForPeriodicJob(
            localEventsGateway = localEventsGateway,
            remoteGateway = remoteGateway,
            clickstreamConfig = clickStreamConfig
        )

    // TODO: move client init to network module
    private fun buildCioHttpClient(
        headers: Map<String, () -> String>,
        baseUrl: String
    ): HttpClient {

        val httpClient = HttpClient(CIO) {
            expectSuccess = true
            defaultRequest {
                url.protocol = URLProtocol.HTTPS
                val urlBuilder = URLBuilder(Url(baseUrl))
                urlBuilder.encodedPath += urlBuilder.encodedPath
                url.takeFrom(urlBuilder)
            }
            // TODO: check, that logging working only on debug
            install(Logging)
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        httpClient.plugin(HttpSend).intercept { request ->
            headers.forEach { (k, v) ->
                request.header(k, v.invoke())
            }
            execute(request)
        }
        return httpClient
    }

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        initPeriodicWork()
        send(ClickstreamBuilder().builder())
    }

    fun exposure(
        experimentId: String,
        variantId: String,
        exposedAt: String,
    ) {
        coroutineScope.launch {
            exposureExperimentsApi(
                experimentId, variantId, exposedAt
            )
        }
    }

    private fun createGrowthExposure(propertiesProvider: PropertiesProvider) {
        val installId = requireNotNull(
            value = propertiesProvider.userProps
                .properties()
                .find { it.key == UserInstallIdProperty.KEY },
            lazyMessage = { "should be defined" }
        )
        exposureExperimentsApi = ExposureExperimentsImpl(api = api, installId = installId)
    }

    private fun initPeriodicWork() {
        analyticsJobScheduler.init(clickStreamConfig = clickStreamConfig)
        analyticsJobScheduler.startWork()
    }

    fun sender(): AnalyticsEventSender = sender

    private fun createAnalyticsClickStreamSender(
        localEventsGateway: LocalEventsGateway,
        mapEventToDatabaseEntity: MapEventToDatabaseEntity,
    ): AnalyticsEventSender =
        ClickstreamAnalyticsEventSender(localEventsGateway, mapEventToDatabaseEntity)

    private fun createMapEventToDatabaseEntity(
        dependencies: PlatformDependencies,
        propertiesProvider: PropertiesProvider,
        eventPropertiesDelegate: EventPropertiesDelegate,
    ): MapEventToDatabaseEntity = MapEventToDatabaseEntity(
        dependencies = dependencies,
        propertiesProvider = propertiesProvider,
        eventPropertiesDelegate = eventPropertiesDelegate,
    )

    private fun send(event: ClickstreamEvent) {
        coroutineScope.launch {
            sender.send(event)
        }
    }
}
