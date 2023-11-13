package analytics.sdk.clickstream

import analytics.sdk.platform.IosDependencies
import analytics.sdk.properties.PropertiesProvider

fun ClickstreamSdk.initialize(
    url: String,
    propertiesProvider: PropertiesProvider?,
    requestHeaders: Map<String, () -> String>,
) {
    initialize(
        url = url,
        propertiesProvider = propertiesProvider,
        clickStreamConfig = ClickstreamConfig(),
        requestHeaders = requestHeaders,
    )
}

fun ClickstreamSdk.initialize(
    url: String,
    propertiesProvider: PropertiesProvider?,
    clickStreamConfig: ClickstreamConfig,
    requestHeaders: Map<String, () -> String>,
) {
    initialize(
        url = url,
        dependencies = IosDependencies(),
        propertiesProvider = propertiesProvider,
        clickStreamConfig = clickStreamConfig,
        requestHeaders = requestHeaders,
        analyticsJobScheduler = AnalyticsJobScheduler(),
    )
}
