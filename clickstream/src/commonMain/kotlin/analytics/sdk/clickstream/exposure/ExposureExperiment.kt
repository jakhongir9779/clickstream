package analytics.sdk.clickstream.exposure

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExposureExperiment(
    val experimentId: String,
    val variantId: String,
    val exposedAt: String,
    val accountId: String,
)
