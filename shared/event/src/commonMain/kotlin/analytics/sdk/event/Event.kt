package analytics.sdk.event

import analytics.sdk.AnalyticsType

interface Event {
    val analyticsType: AnalyticsType
}
