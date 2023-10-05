package analytics.sdk.clickstream.builder.space

import kotlinx.serialization.Serializable

@Serializable
data class Space internal constructor(
    val id: String?,
    val name: String,
    val type: Type,
    val screenSize: String,
) {
    enum class Type {
        PAGE,
        MODAL,
    }
}
