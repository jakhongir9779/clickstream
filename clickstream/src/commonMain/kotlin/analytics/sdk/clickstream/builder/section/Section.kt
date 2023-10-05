package analytics.sdk.clickstream.builder.section

import kotlinx.serialization.Serializable

@Serializable
data class Section internal constructor(
    val id: String?,
    val type: String?,
    val name: String,
    val position: Long?,
)
