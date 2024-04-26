package analytics.sdk.clickstream

import analytics.sdk.clickstream.domain.ClickstreamConfig
import kotlinx.coroutines.CoroutineScope

expect class AnalyticsJobScheduler {
    fun init(clickStreamConfig: ClickstreamConfig)
    fun startWork(coroutineScope: CoroutineScope)
}
