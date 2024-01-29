package analytics.sdk.clickstream.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal class EventProperties(
    @SerialName("event_type")
    val event_type: String,

    @SerialName("event_parameters")
    val event_parameters: JsonObject
)
