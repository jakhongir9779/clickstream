package analytics.sdk.clickstream.lifecycle

import analytics.sdk.clickstream.Clickstream

object AppLifecycleTracker {

    fun start() {
        AppLifecycle.registerLifecycleCallbacks { lifecycleEvent ->
            sendLifecycleEvent(lifecycleEvent)
        }
    }

    private fun sendLifecycleEvent(lifecycleEvent: AppLifecycleEvent) {
        Clickstream.send {
            event {
                type("APP_LIFECYCLE")
                parameter("name", lifecycleEvent.name)
            }.build()
        }
    }

}
