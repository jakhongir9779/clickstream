package analytics.sdk.common

import analytics.sdk.clickstream.ClickstreamConfig

expect class AnalyticsJobScheduler {
    fun init(clickStreamConfig: ClickstreamConfig)
    fun startWork()
}