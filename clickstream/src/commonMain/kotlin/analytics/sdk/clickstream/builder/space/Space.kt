package analytics.sdk.clickstream.builder.space

data class Space internal constructor(
    val id: String?,
    val name: String,
    val type: Space.Type,
    val screenSize: String,
) {
    enum class Type {
        PAGE,
        MODAL,
    }
}
