package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.di.initKoin
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.common.extensions.multiParametersOf
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider
import org.koin.core.component.KoinComponent

object Clickstream {

    private var clickstreamSdk: ClickstreamSdkImpl? = null
    fun initialize(
        url: String,
        dependencies: PlatformDependencies,
        requestHeaders: Map<String, () -> String>,
        clickStreamConfig: ClickstreamConfig,
        analyticsJobScheduler: AnalyticsJobScheduler,
        propertiesProvider: PropertiesProvider?,
    ) {
        val koinApp = initKoin()

        clickstreamSdk = koinApp.koin.get<ClickstreamSdkImpl> {
            multiParametersOf(
                url,
                dependencies,
                requestHeaders,
                clickStreamConfig,
                analyticsJobScheduler,
                propertiesProvider
            )
        }
    }
    fun getDataForPeriodicJob() = clickstreamSdk?.getDataForPeriodicJob()
        ?: throw Exception("Run ClickstreamSdk.initialize() first")

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        instance.send(builder)
    }

    private val instance
        get() = clickstreamSdk ?: throw Exception("Run ClickstreamSdk.initalize() first")


}