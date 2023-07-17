package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.database.ClickstreamDatabase
import analytics.sdk.clickstream.data.model.Event
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.clickstream.exposure.ExposureExperimentsApi
import analytics.sdk.clickstream.exposure.ExposureExperimentsImpl
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGatewayImpl
import analytics.sdk.clickstream.gateway.LocalEventsGateway
import analytics.sdk.clickstream.gateway.RequestInterceptor
import analytics.sdk.clickstream.mappers.MapEventToDatabaseEntity
import analytics.sdk.clickstream.properties.ClickstreamLifecycleCallbacks
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
import analytics.sdk.clickstream.properties.user.default.UserInstallIdProperty
import analytics.sdk.clickstream.properties.user.default.getDefaultUserProperties
import analytics.sdk.common.AnalyticsEventSender
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import timber.log.Timber
import java.util.Calendar
import java.util.TreeMap
import java.util.UUID
import kotlin.properties.Delegates

@Suppress("UNCHECKED_CAST")
class ClickstreamSdk(
    applicationContext: Context,
    url: String,
    propertiesProvider: PropertiesProvider,
    clickStreamConfig: ClickstreamConfig,
    requestHeaders: Map<String, () -> String>,
    private val isDebug: Boolean = false,
) {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(
            Exception(
                "ClickStreamSdk", throwable
            )
        )
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
        check(applicationContext is Application)
        database = createDatabase(applicationContext)
        localEventsGateway = database.events()
        val eventPropertiesDelegate = createEventPropertiesDelegate(applicationContext)
        val moshi = Moshi.Builder().build()
        val connectivity = Connectivity()
        sender = createAnalyticsClickStreamSender(
            localEventsGateway, createMapEventToDatabaseEntity(
                moshi,
                propertiesProvider,
                eventPropertiesDelegate,
                { connectivity.isConnectedWifi(applicationContext.applicationContext) },
            )
        )

        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit =
            Retrofit.Builder().baseUrl(url).addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi)).client(
                    okHttpClient.newBuilder().addInterceptor(RequestInterceptor(requestHeaders))
                        .addDebugHttpLoggingInterceptor().build()
                ).build()
        if (isDebug) {
            Timber.plant(Timber.DebugTree())
        }
        api = retrofit.create(ClickstreamAnalyticsApi::class.java)
        createGrowthExposure(propertiesProvider)
        remoteGateway = ClickstreamRemoteGatewayImpl(api)
        worker = AnalyticsWorker.get(
            localEventsGateway, remoteGateway, clickStreamConfig
        )

        applicationContext.registerActivityLifecycleCallbacks(
            ClickstreamLifecycleCallbacks(
                applicationContext,
                eventPropertiesDelegate,
                eventPropertiesDelegate,
            )
        )
    }

    fun send(
        builder: ClickstreamBuilder.() -> ClickstreamEvent
    ) {
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
        exposureExperimentsApi = ExposureExperimentsImpl(api,
            propertiesProvider.userProps.properties()
                .find { it.key == UserInstallIdProperty.INSTALL_ID } ?: error("should be defined"))
    }

    fun sender(): AnalyticsEventSender = sender

    private fun OkHttpClient.Builder.addDebugHttpLoggingInterceptor(): OkHttpClient.Builder =
        with(this) {
            val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            if (isDebug) addInterceptor(interceptor)
            else this
        }

    private fun createEventPropertiesDelegate(
        context: Context,
    ): EventPropertiesDelegate = EventPropertiesDelegate(context.getSharedPreferences(
        EventPropertiesDelegate.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE
    ),
        { UUID.randomUUID().toString() },
        { Calendar.getInstance().timeZone.id },
        { System.currentTimeMillis() })

    private fun createAnalyticsClickStreamSender(
        localEventsGateway: LocalEventsGateway,
        mapEventToDatabaseEntity: MapEventToDatabaseEntity,
    ): AnalyticsEventSender =
        ClickstreamAnalyticsEventSender(localEventsGateway, mapEventToDatabaseEntity)

    private fun createMapEventToDatabaseEntity(
        moshi: Moshi,
        propertiesProvider: PropertiesProvider,
        eventPropertiesDelegate: EventPropertiesDelegate,
        isWifiConnection: () -> Boolean,
    ): MapEventToDatabaseEntity = MapEventToDatabaseEntity(
        eventAdapter = moshi.adapter(Event::class.java),
        propertiesProvider = propertiesProvider,
        eventPropertiesDelegate = eventPropertiesDelegate,
        timestamp = { System.currentTimeMillis() },
        isWifiConnection = isWifiConnection,
    )

    private fun createDatabase(context: Context): ClickstreamDatabase =
        ClickstreamDatabase.get(context)

    private fun send(event: ClickstreamEvent) {
        coroutineScope.launch {
            sender.send(event)
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: ClickstreamSdk? = null

        private const val SHARED_PREF_KEY = "clickstream"

        fun initialize(
            applicationContext: Context,
            url: String,
            clickStreamPropProviders: PropertiesProvider?,
            appVersion: String,
            packageName: String,
            config: ClickstreamConfig = ClickstreamConfig(5, 20),
            requestHeaders: Map<String, () -> String> = emptyMap(),
            isDebug: Boolean,
        ): ClickstreamSdk {
            synchronized(this) {
                if (INSTANCE != null) error("already initialized")
                val defaultPropertiesProvider = createDefaultPropertyProviders(
                    appVersion = appVersion,
                    packageName = packageName,
                    context = applicationContext,
                    sharedPreferences = applicationContext.getSharedPreferences(
                        SHARED_PREF_KEY, Context.MODE_PRIVATE
                    ),
                    getUUID = { UUID.randomUUID().toString() },
                )

                // should drop default in case of conflict
                val appProps = defaultPropertiesProvider.appProvider.properties().apply {
                    clickStreamPropProviders?.appProvider?.let {
                        val replaced = it.properties().map { it.key }.intersect(this.map { it.key })
                        Timber.w("This app properties conflicted ${replaced.joinToString(separator = ",") { it }}, default keys will be replaced")
                        plus(it.properties())
                    }
                }

                val userProps = defaultPropertiesProvider.userProps.properties().apply {
                    clickStreamPropProviders?.userProps?.let {
                        val replaced = it.properties().map { it.key }.intersect(this.map { it.key })
                        Timber.w("This user properties conflicted ${replaced.joinToString(separator = ",") { it }}, default keys will be replaced")
                        plus(it.properties())
                    }
                }

                val deviceProps = defaultPropertiesProvider.deviceProps.properties().apply {
                    clickStreamPropProviders?.deviceProps?.let {
                        val replaced = it.properties().map { it.key }.intersect(this.map { it.key })
                        Timber.w("This device properties conflicted ${
                            replaced.joinToString(
                                separator = ","
                            ) { it }
                        }, default keys will be replaced")
                        plus(it.properties())
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
                    url = url,
                    propertiesProvider = mergedPropertiesProviders,
                    requestHeaders = requestHeaders,
                    clickStreamConfig = config,
                    isDebug = isDebug,
                )

                INSTANCE = clickStream
            }
            return INSTANCE ?: throw IllegalStateException("can't be null")
        }

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
    sharedPreferences: SharedPreferences,
    getUUID: () -> String,
    getExistingInstallId: (() -> String)? = null
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
            sharedPreferences,
            getUUID,
            getExistingInstallId,
        )
    ),
)
