package analytics.sdk.clickstream.lifecycle

actual object AppLifecycle {
    actual fun registerLifecycleCallbacks(onEvent: (AppLifecycleEvent) -> Unit) {
        // TODO: ADD IOS IMPLEMENTATION WITH UIApplicationDelegate
    }

}