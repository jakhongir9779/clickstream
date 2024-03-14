package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider

object Clickstream {

    private var clickstreamSdkImpl: ClickstreamSdkImpl? = null
    fun initialize(
        url: String,
        dependencies: PlatformDependencies,
        requestHeaders: Map<String, () -> String>,
        clickStreamConfig: ClickstreamConfig,
        analyticsJobScheduler: AnalyticsJobScheduler,
        propertiesProvider: PropertiesProvider?,
    ) {
        clickstreamSdkImpl = ClickstreamSdkImpl(
            url = url,
            dependencies = dependencies,
            requestHeaders = requestHeaders,
            clickStreamConfig = clickStreamConfig,
            analyticsJobScheduler = analyticsJobScheduler,
            propertiesProvider = propertiesProvider
        )
    }

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        instance.send(builder)
    }

    private val instance
        get() = clickstreamSdkImpl ?: throw Exception("Run ClickstreamSdk.initalize() first")

    fun getDataForPeriodicJob() = clickstreamSdkImpl?.getDataForPeriodicJob()
        ?: throw Exception("Run ClickstreamSdk.initialize() first")
}