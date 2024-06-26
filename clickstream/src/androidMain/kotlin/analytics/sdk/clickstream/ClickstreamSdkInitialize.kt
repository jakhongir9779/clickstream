package analytics.sdk.clickstream

import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.properties.PropertiesProvider
import android.content.Context


// Initialize for Android
fun Clickstream.initializeForAndroid(
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
        clickStreamConfig = config,
        requestHeaders = requestHeaders,
        analyticsJobScheduler = AnalyticsJobScheduler(context),
    )
}


