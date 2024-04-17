package analytics.sdk.clickstream.lifecycle

internal actual object AppLifecycle {
    actual fun registerLifecycleCallbacks(onEvent: (AppLifecycleEvent) -> Unit) {
        // TODO: ADD IOS IMPLEMENTATION WITH UIApplicationDelegate
    }

}