package analytics.sdk.clickstream.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal class EventProperties(
    val eventType: String,

    val eventParameters: JsonObject
)
