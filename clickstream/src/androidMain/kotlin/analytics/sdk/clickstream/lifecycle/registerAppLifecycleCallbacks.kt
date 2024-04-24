package analytics.sdk.clickstream.lifecycle

import analytics.sdk.clickstream.Clickstream
import androidx.lifecycle.ProcessLifecycleOwner

internal actual fun registerAppLifecycleCallbacks(enabled: Boolean) {
    ProcessLifecycleOwner.get().lifecycle.addObserver(AndroidAppLifecycleObserver(onEvent = { lifecycleEvent ->
        Clickstream.send {
            event {
                type("APP_LIFECYCLE")
                parameter("name", lifecycleEvent.name)
            }.build()
        }
    }))
}
