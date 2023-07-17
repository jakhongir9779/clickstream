package analytics.sdk.clickstream.exposure

interface ExposureExperimentsApi {

    suspend operator fun invoke(
        experimentId: String,
        variantId: String,
        exposedAt: String,
    )
}
