package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickStreamAnalyticsApiImpl
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.clickstream.exposure.ExposureExperimentsApi
import analytics.sdk.clickstream.exposure.ExposureExperimentsImpl
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGatewayImpl
import analytics.sdk.clickstream.mappers.MapEventToDatabaseEntity
import analytics.sdk.clickstream.properties.EventPropertiesDelegate
import analytics.sdk.clickstream.properties.PropertiesProvider
import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsProperties
import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.application.default.getDefaultAppProperties
import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties
import analytics.sdk.clickstream.properties.device.DeviceAnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.device.default.getDefaultDeviceProperties
import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties
import analytics.sdk.clickstream.properties.user.UserAnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.user.default.getDefaultUserProperties
import analytics.sdk.clickstream.settings.ClickStreamSettings
import analytics.sdk.clickstream.settings.EventPropertiesSettings
import analytics.sdk.common.AnalyticsEventSender
import android.app.Application
import android.content.Context
import com.russhwolf.settings.Settings
import com.squareup.moshi.Moshi
import analytics.sdk.database.ClickstreamDatabase
import analytics.sdk.database.DriverFactory
import analytics.sdk.database.gateway.LocalEventsGateway
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
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import timber.log.Timber
import java.util.Calendar
import java.util.UUID
import kotlinx.serialization.json.Json
import kotlin.jvm.Volatile
import kotlin.properties.Delegates

@Suppress("UNCHECKED_CAST")
class ClickstreamSdk(
    urlString: String,
    propertiesProvider: PropertiesProvider,
    clickStreamConfig: ClickstreamConfig,
    requestHeaders: Map<String, () -> String>,
    private val settings: Settings,
    private val isDebug: Boolean = false,
) {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Exception in coroutine: $throwable")
    }

    private val coroutineScope = CoroutineScope(
        SupervisorJob() + Dispatchers.IO + coroutineExceptionHandler,
    )

    private var database: ClickstreamDatabase by Delegates.notNull()
    private var sender: AnalyticsEventSender by Delegates.notNull()
    private var localEventsGateway: LocalEventsGateway by Delegates.notNull()

    private var api: ClickstreamAnalyticsApi by Delegates.notNull()
    private var remoteGateway: ClickstreamRemoteGateway by Delegates.notNull()
    private var worker: AnalyticsWorker by Delegates.notNull()

    private var exposureExperimentsApi: ExposureExperimentsApi by Delegates.notNull()

    // ORDER MATTERS
    // DO NOT CHANGE
    init {
//        check(applicationContext is Application)
        database = ClickstreamDatabase(clickStreamConfig.databaseDriverFactory)
        localEventsGateway = database.queries()
        val eventPropertiesDelegate = createEventPropertiesDelegate(/*applicationContext*/)
//        val connectivity = Connectivity()
        sender = createAnalyticsClickStreamSender(
            localEventsGateway, createMapEventToDatabaseEntity(
//                moshi,
                propertiesProvider,
                eventPropertiesDelegate,
                { /*connectivity.isConnectedWifi(applicationContext.applicationContext)*/
                    true
                },
            )
        )

        api = ClickStreamAnalyticsApiImpl(buildCioHttpClient(requestHeaders, urlString))
        createGrowthExposure(propertiesProvider)
        remoteGateway = ClickstreamRemoteGatewayImpl(api)
        worker = AnalyticsWorker.get(
            localEventsGateway, remoteGateway, clickStreamConfig
        )

//        applicationContext.registerActivityLifecycleCallbacks(
//            ClickstreamLifecycleCallbacks(
//                applicationContext,
//                eventPropertiesDelegate,
//                eventPropertiesDelegate,
//            )
//        )
    }

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
                request.header(k, v)
            }
            execute(request)
        }
        return httpClient
    }

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
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
                .find { it.key == ClickStreamSettings.INSTALL_ID },
            lazyMessage = { "should be defined" }
        )
        exposureExperimentsApi = ExposureExperimentsImpl(api = api, installId = installId)
    }

    fun sender(): AnalyticsEventSender = sender

//    private fun OkHttpClient.Builder.addDebugHttpLoggingInterceptor(): OkHttpClient.Builder =
//        with(this) {
//            val interceptor = HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//            if (isDebug) addInterceptor(interceptor)
//            else this
//        }

    private fun createEventPropertiesDelegate(context: Context): EventPropertiesDelegate =
        EventPropertiesDelegate(
            eventPropertiesSettings = EventPropertiesSettings(settings),
            generateUUID = { UUID.randomUUID().toString() },
            getTimezoneId = { Calendar.getInstance().timeZone.id },
            generateTimestamp = { System.currentTimeMillis() },
        )

    private fun createAnalyticsClickStreamSender(
        localEventsGateway: LocalEventsGateway,
        mapEventToDatabaseEntity: MapEventToDatabaseEntity,
    ): AnalyticsEventSender =
        ClickstreamAnalyticsEventSender(localEventsGateway, mapEventToDatabaseEntity)

    private fun createMapEventToDatabaseEntity(
//        moshi: Moshi,
        propertiesProvider: PropertiesProvider,
        eventPropertiesDelegate: EventPropertiesDelegate,
        isWifiConnection: () -> Boolean,
    ): MapEventToDatabaseEntity = MapEventToDatabaseEntity(
//        eventAdapter = moshi.adapter(Event::class.java),
        propertiesProvider = propertiesProvider,
        eventPropertiesDelegate = eventPropertiesDelegate,
        timestamp = { /*System.currentTimeMillis()*/ 0 },
        isWifiConnection = isWifiConnection,
    )

    private fun send(event: ClickstreamEvent) {
        coroutineScope.launch {
            sender.send(event)
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: ClickstreamSdk? = null

        fun initialize(
            url: String,
            clickStreamPropProviders: PropertiesProvider?,
            appVersion: String,
            packageName: String,
            driverFactory: DriverFactory,
            config: ClickstreamConfig = ClickstreamConfig(5, 20, driverFactory),
            requestHeaders: Map<String, () -> String> = emptyMap(),
            isDebug: Boolean,
            settings: Settings,
        ): ClickstreamSdk {
            synchronized(this) {
                if (INSTANCE != null) error("already initialized")
                val defaultPropertiesProvider = createDefaultPropertyProviders(
                    appVersion = appVersion,
                    packageName = packageName,
                    context = applicationContext,
                    clickStreamSettings = ClickStreamSettings(settings),
                    getUUID = { UUID.randomUUID().toString() },
                )

                // should drop default in case of conflict
                val appProps = defaultPropertiesProvider.appProvider.properties().apply {
                    clickStreamPropProviders?.appProvider?.let { provider ->
                        val replaced = provider.properties()
                            .map { it.key }
                            .intersect(this.map { it.key }.toSet())
                        Logger.w {
                            "This app properties conflicted " +
                                    "${replaced.joinToString(separator = ",") { it }}, " +
                                    "default keys will be replaced"
                        }
                        plus(provider.properties())
                    }
                }

                val userProps = defaultPropertiesProvider.userProps.properties().apply {
                    clickStreamPropProviders?.userProps?.let { provider ->
                        val replaced = provider.properties()
                            .map { it.key }
                            .intersect(this.map { it.key }.toSet())
                        Logger.w {
                            "This user properties conflicted " +
                                    "${replaced.joinToString(separator = ",") { it }}, " +
                                    "default keys will be replaced"
                        }
                        plus(provider.properties())
                    }
                }

                val deviceProps = defaultPropertiesProvider.deviceProps.properties().apply {
                    clickStreamPropProviders?.deviceProps?.let { provider ->
                        val replaced = provider.properties()
                            .map { it.key }
                            .intersect(this.map { it.key }.toSet())
                        Logger.w {
                            "This device properties conflicted " +
                                    "${replaced.joinToString(separator = ",") { it }}, " +
                                    "default keys will be replaced"
                        }
                        plus(provider.properties())
                    }
                }

                val mergedPropertiesProviders = PropertiesProvider(
                    appProvider = ApplicationAnalyticsPropertyProvider(
                        appProps as Set<ApplicationAnalyticsProperties>
                    ), userProps = UserAnalyticsPropertyProvider(
                        userProps as Set<UserAnalyticsProperties>
                    ), deviceProps = DeviceAnalyticsPropertyProvider(
                        deviceProps as Set<DeviceAnalyticsProperties>
                    )
                )

                val clickStream = ClickstreamSdk(
                    applicationContext = applicationContext,
                    urlString = url,
                    propertiesProvider = mergedPropertiesProviders,
                    requestHeaders = requestHeaders,
                    clickStreamConfig = config,
                    isDebug = isDebug,
                    settings = settings,
                )

                INSTANCE = clickStream
            }
            return INSTANCE ?: throw IllegalStateException("can't be null")
        }

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(): ClickstreamSdk {
            synchronized(this) {
                return INSTANCE ?: throw IllegalStateException("Must be initialized first")
            }
        }
    }
}

private fun createDefaultPropertyProviders(
    context: Context,
    appVersion: String,
    packageName: String,
    clickStreamSettings: ClickStreamSettings,
    getUUID: () -> String,
    getExistingInstallId: (() -> String)? = null,
): PropertiesProvider = PropertiesProvider(
    appProvider = ApplicationAnalyticsPropertyProvider(
        getDefaultAppProperties(
            appVersion = appVersion,
            packageName = packageName,
        ),
    ),
    deviceProps = DeviceAnalyticsPropertyProvider(
        getDefaultDeviceProperties(context)
    ),
    userProps = UserAnalyticsPropertyProvider(
        getDefaultUserProperties(
            context,
            clickStreamSettings,
            getUUID,
            getExistingInstallId,
        )
    ),
)
