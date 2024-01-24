package analytics.sdk.clickstream

class ClickstreamConfig(
    val sizeOfBatch: Long = 5,
    val sendDataPeriodicityInMinutes: Double = 15.0,
)
