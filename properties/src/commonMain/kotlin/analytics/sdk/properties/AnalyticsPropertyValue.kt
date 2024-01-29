package analytics.sdk.properties

interface AnalyticsPropertyValue {
    val key: String
    fun getValue(): String?
}
