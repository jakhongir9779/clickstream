package analytics.sdk.clickstream.builder.group

import kotlinx.serialization.Serializable

@Serializable
data class Group internal constructor(
    val name: String,
    val position: Long?
)
