package analytics.sdk.clickstream.lifecycle

expect object AppLifecycle {
    fun registerLifecycleCallbacks(onEvent: (AppLifecycleEvent) -> Unit)

}