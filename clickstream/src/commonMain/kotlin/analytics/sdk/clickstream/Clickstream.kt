package analytics.sdk.clickstream

import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.di.initKoin
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
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

    fun deeplinkOpened(deeplink: String) {
        send {
            event {
                type("DEEPLINK_OPENED")
                val keyValuePairs = getDeeplinkParamPairs(deeplink)
                keyValuePairs.forEach { (key, value) ->
                    parameter(key, value)
                }
                parameter("link", deeplink)
            }.build()
        }
    }

    private fun getDeeplinkParamPairs(deeplink: String) =
        deeplink.substringAfter('?').split('&').map {
            val keyValue = it.split('=')
            (keyValue.firstOrNull() ?: "") to (keyValue.getOrNull(1) ?: "")
        }

    val instance
        get() = clickstreamSdk ?: throw Exception("Run ClickstreamSdk.initalize() first")

}