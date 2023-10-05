package analytics.sdk.clickstream.data.model

import kotlinx.serialization.Serializable


@Serializable
internal data class Event(
    val counter: Long? = null,

    // Local timezone; example: Europe/Moscow
    val time_zone: String? = null,

    // Local time of event in Unix timestamp milliseconds format; example: 1603377799962
    val timestamp: Long,

    val ui_properties: UiProperties? = null,

    val event_properties: EventProperties? = null,

    val connection_type: ConnectionType = ConnectionType.UNKNOWN,

    val is_interactive: Boolean = true
)
