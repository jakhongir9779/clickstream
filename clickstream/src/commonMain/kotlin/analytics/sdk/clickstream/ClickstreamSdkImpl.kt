package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.exposure.ExposureExperimentsImpl
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.platform.properties.EventPropertiesDelegate
import analytics.sdk.properties.PropertiesProvider
import analytics.sdk.properties.mergePropertiesWithDefault
import analytics.sdk.properties.user.default.InstallIdProperties
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class ClickstreamSdkImpl(
    val dependencies: PlatformDependencies,
    val clickStreamConfig: ClickstreamConfig,
    val analyticsJobScheduler: AnalyticsJobScheduler,
    propertiesProvider: PropertiesProvider?,
    api: ClickstreamAnalyticsApi,
    val sender: AnalyticsEventSender,
) : CoroutineScope {


    private val eventPropertiesDelegate = EventPropertiesDelegate(dependencies)

    private val defaultPropertiesProvider =
        mergePropertiesWithDefault(dependencies, propertiesProvider)
    private val exposureExperimentsApi = createGrowthExposure(defaultPropertiesProvider, api)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "ClickStreamSdk" }
    }

    init {
        dependencies.utils.subscribeOnSessionUpdate(eventPropertiesDelegate)
    }

    fun sendFingerPrint() {
        launch {
            dependencies.fingerprinter.getData()
        }
    }

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        initPeriodicWork()
        sendEvent(ClickstreamBuilder().builder())
    }

    fun exposure(
        experimentId: String,
        variantId: String,
        exposedAt: String,
    ) {
        launch {
            exposureExperimentsApi(experimentId, variantId, exposedAt)
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


    private fun sendEvent(event: ClickstreamEvent) {
        launch {
            sender.send(event)
        }
    }

    override val coroutineContext: CoroutineContext =
        SupervisorJob() + Dispatchers.IO + coroutineExceptionHandler
}
