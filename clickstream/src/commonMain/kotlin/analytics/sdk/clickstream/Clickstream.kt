package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.di.initKoin
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.clickstream.domain.model.ScreenLifecycleState
import analytics.sdk.common.extensions.multiParametersOf
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider

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

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        instance.send(builder)
    }

    fun sendScreenLifecycleChange(screenName: String, lifecycleState: ScreenLifecycleState) {
        when(lifecycleState) {
            ScreenLifecycleState.CREATED -> TODO()
            ScreenLifecycleState.RESUMED -> TODO()
            ScreenLifecycleState.STOPPED -> TODO()
            ScreenLifecycleState.PAUSED -> TODO()
        }
    }

    val instance
        get() = clickstreamSdk ?: throw Exception("Run ClickstreamSdk.initalize() first")

}