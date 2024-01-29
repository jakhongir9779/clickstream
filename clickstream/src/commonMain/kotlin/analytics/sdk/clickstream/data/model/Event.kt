package analytics.sdk.clickstream.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
internal data class Event(
    val counter: Long? = null,

    // Local timezone; example: Europe/Moscow
    @SerialName("time_zone")
    val timeZone: String? = null,

    // Local time of event in Unix timestamp milliseconds format; example: 1603377799962
    val timestamp: Long,

    @SerialName("ui_properties")
    val uiProperties: UiProperties? = null,

    @SerialName("event_properties")
    val eventProperties: EventProperties? = null,

    @SerialName("connection_type")
    val connectionType: ConnectionType = ConnectionType.UNKNOWN,

    @SerialName("is_interactive")
    val isInteractive: Boolean
)
