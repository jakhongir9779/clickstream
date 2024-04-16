package analytics.sdk.clickstream

import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.firebase.ClickstreamNotificationsReceiver
import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.properties.PropertiesProvider
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_DISABLED
import android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_ENABLED


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
    val compName = ComponentName(context, ClickstreamNotificationsReceiver::class.java)
    val notificationsReceiverState =
        if (config.trackNotifications) COMPONENT_ENABLED_STATE_ENABLED else COMPONENT_ENABLED_STATE_DISABLED
    context.packageManager.setComponentEnabledSetting(
        compName,
        notificationsReceiverState,
        PackageManager.DONT_KILL_APP
    )
}
