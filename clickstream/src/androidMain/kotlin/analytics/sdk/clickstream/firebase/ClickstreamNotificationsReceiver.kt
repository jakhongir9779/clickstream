package analytics.sdk.clickstream.firebase

import analytics.sdk.clickstream.Clickstream
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

internal class ClickstreamNotificationsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val notificationTitle = intent?.getStringExtra("gcm.notification.title")
        val notificationBody = intent?.getStringExtra("gcm.notification.body")
        if (notificationTitle != null || notificationBody != null) {
            Clickstream.send {
                event {
                    notificationBody?.let { parameter("body", it) }
                    notificationTitle?.let { parameter("title", it) }
                    type("NOTIFICATION_RECEIVED")
                }.build()
            }
        }
    }
}