package analytics.sdk.clickstream.properties

interface AnalyticsPropertyValue {
    val key: String
    fun getValue(): String?
}
