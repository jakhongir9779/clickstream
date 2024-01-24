package analytics.sdk.clickstream

import analytics.sdk.platform.IosDependencies
import analytics.sdk.properties.PropertiesProvider

fun ClickstreamSdk.initialize(
    url: String,
    requestHeaders: Map<String, () -> String>,
    config: ClickstreamConfig,
    propertiesProvider: PropertiesProvider?,
) {
    initialize(
        url = url,
        dependencies = IosDependencies(),
        propertiesProvider = propertiesProvider,
        config = config,
        requestHeaders = requestHeaders,
        analyticsJobScheduler = AnalyticsJobScheduler(),
    )
}
