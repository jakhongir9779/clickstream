package analytics.sdk.clickstream

expect class AnalyticsJobScheduler {
    fun init(clickStreamConfig: ClickstreamConfig)
    fun startWork()
}