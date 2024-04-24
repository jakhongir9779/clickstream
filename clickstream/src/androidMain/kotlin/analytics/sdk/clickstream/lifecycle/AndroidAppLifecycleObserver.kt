package analytics.sdk.clickstream.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


class AndroidAppLifecycleObserver(val onEvent: (AppLifecycleEvent) -> Unit) :
    LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> onEvent(AppLifecycleEvent.STARTED)
            Lifecycle.Event.ON_STOP -> onEvent(AppLifecycleEvent.STOPPED)
            Lifecycle.Event.ON_RESUME -> onEvent(AppLifecycleEvent.RESUMED)
            else -> {}
        }
    }
}
