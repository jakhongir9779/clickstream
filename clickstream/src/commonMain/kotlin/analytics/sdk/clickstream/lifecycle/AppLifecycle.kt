package analytics.sdk.clickstream.lifecycle

internal expect object AppLifecycle {
    fun registerLifecycleCallbacks(onEvent: (AppLifecycleEvent) -> Unit)

}