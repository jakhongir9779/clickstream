package analytics.sdk.clickstream.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


class AndroidAppLifecycleObserver(val onEvent: (AppLifecycleEvent) -> Unit) :
    LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> onEvent(AppLifecycleEvent.ON_CREATE)
            Lifecycle.Event.ON_START -> onEvent(AppLifecycleEvent.ON_START)
            Lifecycle.Event.ON_RESUME -> onEvent(AppLifecycleEvent.ON_RESUME)
            Lifecycle.Event.ON_PAUSE -> onEvent(AppLifecycleEvent.ON_PAUSE)
            Lifecycle.Event.ON_STOP -> onEvent(AppLifecycleEvent.ON_STOP)
            Lifecycle.Event.ON_DESTROY -> onEvent(AppLifecycleEvent.ON_DESTROY)
            Lifecycle.Event.ON_ANY -> {}
        }
    }
}
