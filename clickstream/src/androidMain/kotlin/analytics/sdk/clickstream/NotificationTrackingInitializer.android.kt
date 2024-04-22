package analytics.sdk.clickstream

import analytics.sdk.clickstream.firebase.ClickstreamNotificationsReceiver
import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import android.content.ComponentName
import android.content.pm.PackageManager

actual fun notificationTrackingInitializer(isEnabled: Boolean, dependencies: PlatformDependencies) {
    require(dependencies is AndroidDependencies)
    val compName = ComponentName(dependencies.context, ClickstreamNotificationsReceiver::class.java)
    val notificationsReceiverState = if (isEnabled) {
        PackageManager.COMPONENT_ENABLED_STATE_ENABLED
    } else {
        PackageManager.COMPONENT_ENABLED_STATE_DISABLED
    }
    dependencies.context.packageManager.setComponentEnabledSetting(
        compName, notificationsReceiverState, PackageManager.DONT_KILL_APP
    )
}