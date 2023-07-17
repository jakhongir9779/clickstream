package analytics.sdk.clickstream.properties

data class Experiments(
    val experiments: String,
)

data class DeeplinkUtmFields(
    val deeplink: String?,
    val referrerUrl: String?,
    val utmSource: String?,
    val utmMedium: String?,
    val utmCampaign: String?,
    val utmTerm: String?,
    val utmContent: String?,
)

data class ViewId(
    val currentViewId: String,
    val lastViewId: String?,
)

data class EventAdditionalProperties(
    val timeZone: String?,
    val timestamp: String?,
    val sessionId: String?,
    val counter: Long,
)
