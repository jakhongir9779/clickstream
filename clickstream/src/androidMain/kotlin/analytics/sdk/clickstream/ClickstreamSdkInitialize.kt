package analytics.sdk.clickstream

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.properties.PropertiesProvider
import android.content.Context

fun ClickstreamSdk.initialize(
    context: Context,
    url: String,
    requestHeaders: Map<String, () -> String>,
    config: ClickstreamConfig = ClickstreamConfig(),
    propertiesProvider: PropertiesProvider? = null,
) {
    initialize(
        url = url,
        dependencies = AndroidDependencies(context),
        propertiesProvider = propertiesProvider,
        config = config,
        requestHeaders = requestHeaders,
        analyticsJobScheduler = AnalyticsJobScheduler(context),
    )
}
