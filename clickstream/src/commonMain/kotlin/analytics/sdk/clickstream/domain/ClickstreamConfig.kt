package analytics.sdk.clickstream.domain

data class ClickstreamConfig(
    val sizeOfBatch: Long = 5,
    val sendDataPeriodicityInMinutes: Double = 15.0,
    val trackAppLifecycle: Boolean = false,
    val trackNotifications: Boolean = false,
)
