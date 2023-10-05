package analytics.sdk.clickstream.builder.properties

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class EventProperties internal constructor(
    val type: String,
    val parameters: JsonObject,
)

internal fun EventProperties?.isValid(): Boolean {
    if (this == null) return false
    return type.isNotEmpty()
}
