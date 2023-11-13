package analytics.sdk.clickstream

class ClickstreamConfig(
    val sizeOfBatch: Int = 5,
    val sendDataPeriodicityInMinutes: Long = 15,
)
