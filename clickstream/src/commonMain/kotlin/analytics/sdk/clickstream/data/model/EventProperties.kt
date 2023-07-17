package analytics.sdk.clickstream.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal class EventProperties(
    @Json(name = "event_type")
    val eventType: String,

    @Json(name = "event_parameters")
    val eventParameters: Map<String, Any>
)
