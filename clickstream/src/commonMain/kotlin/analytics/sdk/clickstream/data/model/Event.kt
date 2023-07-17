package analytics.sdk.clickstream.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class Event(
    @Json(name = "counter")
    val counter: Long? = null,

    // Local timezone; example: Europe/Moscow
    @Json(name = "time_zone")
    val timeZone: String? = null,

    // Local time of event in Unix timestamp milliseconds format; example: 1603377799962
    @Json(name = "timestamp")
    val timestamp: Long,

    @Json(name = "ui_properties")
    val uiProperties: UiProperties? = null,

    @Json(name = "event_properties")
    val eventProperties: EventProperties? = null,

    @Json(name = "connection_type")
    val connectionType: ConnectionType = ConnectionType.UNKNOWN,

    @Json(name = "is_interactive")
    val isInteractive: Boolean = true
)
