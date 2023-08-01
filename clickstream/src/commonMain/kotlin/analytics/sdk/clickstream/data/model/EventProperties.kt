package analytics.sdk.clickstream.data.model

internal class EventProperties(
    val eventType: String,

    val eventParameters: Map<String, Any>
)
