package analytics.sdk.clickstream.exposure



data class ExposureExperiment(
    val experimentId: String,
    val variantId: String,
    val exposedAt: String,
    val accountId: String,
)
