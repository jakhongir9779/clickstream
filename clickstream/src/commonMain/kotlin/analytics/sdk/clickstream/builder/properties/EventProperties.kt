package analytics.sdk.clickstream.builder.properties

data class EventProperties internal constructor(
    val type: String,
    val parameters: Map<String, Any>,
)

internal fun EventProperties?.isValid(): Boolean {
    if (this == null) return false
    return type.isNotEmpty()
}
