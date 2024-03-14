package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickStreamAnalyticsApiImpl
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.DataForPeriodicJob
import analytics.sdk.clickstream.data.exposure.ExposureExperimentsImpl
import analytics.sdk.clickstream.data.gateway.ClickstreamRemoteGatewayImpl
import analytics.sdk.clickstream.data.interactor.ClickstreamAnalyticsEventSender
import analytics.sdk.clickstream.data.mappers.MapEventToDatabaseEntity
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.database.ClickstreamDatabase
import analytics.sdk.database.Event_entity
import analytics.sdk.database.gateway.LocalEventsGatewayImpl
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.platform.properties.EventPropertiesDelegate
import analytics.sdk.properties.PropertiesProvider
import analytics.sdk.properties.mergePropertiesWithDefault
import analytics.sdk.properties.user.default.InstallIdProperties
import co.touchlab.kermit.Logger
import dbJsonAdapter
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlin.coroutines.CoroutineContext

class ClickstreamSdkImpl(
    url: String,
    dependencies: PlatformDependencies,
    requestHeaders: Map<String, () -> String>,
    val clickStreamConfig: ClickstreamConfig,
    val analyticsJobScheduler: AnalyticsJobScheduler,
    propertiesProvider: PropertiesProvider?,
) : CoroutineScope {
    private val eventPropertiesDelegate = EventPropertiesDelegate(dependencies)

    private val localEventsGateway = LocalEventsGatewayImpl(
        ClickstreamDatabase(
            driver = dependencies.databaseDriverFactory.createDriver(),
            event_entityAdapter = Event_entity.Adapter(
                eventJsonAdapter = dbJsonAdapter(),
                propertiesMapJsonAdapter = dbJsonAdapter()
            )
        )
    )

    private val sender = ClickstreamAnalyticsEventSender(
        localEventsGateway, MapEventToDatabaseEntity(
            dependencies = dependencies,
            propertiesProvider = propertiesProvider
                ?: throw Exception("Must initialize propertiesProvider"),
            eventPropertiesDelegate = eventPropertiesDelegate,
        )
    )
    private val api = ClickStreamAnalyticsApiImpl(buildHttpClient(requestHeaders, url))

    private val remoteGateway = ClickstreamRemoteGatewayImpl(api)

    private val defaultPropertiesProvider = mergePropertiesWithDefault(dependencies, propertiesProvider)
    private val exposureExperimentsApi = createGrowthExposure(defaultPropertiesProvider, api)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "ClickStreamSdk" }
    }


    init {
        if (dependencies.utils.initAllowed().not()) {
            throw Exception("Init is not allowed due to dependencies configuration")
        }
        dependencies.utils.subscribeOnSessionUpdate(eventPropertiesDelegate)

    }

    fun getDataForPeriodicJob() =
        DataForPeriodicJob(
            localEventsGateway = localEventsGateway,
            remoteGateway = remoteGateway,
            clickstreamConfig = clickStreamConfig
        )

    // TODO: move client init to network module
    private fun buildHttpClient(
        headers: Map<String, () -> String>,
        baseUrl: String
    ): HttpClient = HttpClient {
        expectSuccess = true
        defaultRequest {
            url(baseUrl)
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = object : io.ktor.client.plugins.logging.Logger {
                override fun log(message: String) {
                    Logger.i { message }
                }
            }
        }
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
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
        launch {
            exposureExperimentsApi(
                experimentId, variantId, exposedAt
            )
        }
    }

    private fun createGrowthExposure(
        propertiesProvider: PropertiesProvider,
        api: ClickstreamAnalyticsApi
    ): ExposureExperimentsImpl {
        val installId = requireNotNull(
            value = propertiesProvider.userProps
                .properties()
                .find { it.key == InstallIdProperties.KEY },
            lazyMessage = { "should be defined" }
        )
        return ExposureExperimentsImpl(api = api, installId = installId)
    }

    private fun initPeriodicWork() {
        analyticsJobScheduler.init(clickStreamConfig = clickStreamConfig)
        analyticsJobScheduler.startWork(coroutineScope = this)
    }


    private fun send(event: ClickstreamEvent) {
        launch {
            sender.send(event)
        }
    }

    override val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.IO + coroutineExceptionHandler
}
