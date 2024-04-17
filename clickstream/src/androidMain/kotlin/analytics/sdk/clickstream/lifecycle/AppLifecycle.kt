package analytics.sdk.clickstream.lifecycle

import androidx.lifecycle.ProcessLifecycleOwner

internal actual object AppLifecycle {
    actual fun registerLifecycleCallbacks(onEvent: (AppLifecycleEvent) -> Unit) {
        ProcessLifecycleOwner.get().lifecycle.addObserver(AndroidAppLifecycleObserver(onEvent))
    }
}