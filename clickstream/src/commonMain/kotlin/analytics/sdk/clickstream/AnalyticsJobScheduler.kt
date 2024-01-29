package analytics.sdk.clickstream

import kotlinx.coroutines.CoroutineScope

expect class AnalyticsJobScheduler {
    fun init(clickStreamConfig: ClickstreamConfig)
    fun startWork(coroutineScope: CoroutineScope)
}
