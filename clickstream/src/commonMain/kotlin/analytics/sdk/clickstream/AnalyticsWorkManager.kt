package analytics.sdk.clickstream

expect class AnalyticsWorkManager {
    fun init(clickStreamConfig: ClickstreamConfig)
    fun startWork()
}