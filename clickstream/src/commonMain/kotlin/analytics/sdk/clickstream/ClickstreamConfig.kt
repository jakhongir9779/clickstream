package analytics.sdk.clickstream

import analytics.sdk.database.DriverFactory

class ClickstreamConfig(
    val delayInSeconds: Long,
    val sizeOfBatch: Int,
    val databaseDriverFactory: DriverFactory,
)
