package analytics.sdk.common

import analytics.sdk.AnalyticsType
import analytics.sdk.event.Event

interface AnalyticsEventSender {
    val type: AnalyticsType
    suspend fun send(event: Event)
}
