package analytics.sdk.clickstream.data

sealed class EventResult(
    open val id: Long,
) {
    data class Succeed(override val id: Long) : EventResult(id)
    data class Failed(override val id: Long) : EventResult(id)
}
