package analytics.sdk.clickstream

import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider

object ClickstreamSdk {

    var clickstreamSdkImpl: ClickstreamSdkImpl? = null
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

    val instance
        get() = clickstreamSdkImpl ?: throw Exception("Run ClickstreamSdk.initalize() first")

    fun getDataForPeriodicJob() = clickstreamSdkImpl?.getDataForPeriodicJob()
        ?: throw Exception("Run ClickstreamSdk.initalize() first")
}