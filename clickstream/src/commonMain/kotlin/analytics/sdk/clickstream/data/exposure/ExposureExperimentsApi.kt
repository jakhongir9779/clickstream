package analytics.sdk.clickstream.data.exposure

interface ExposureExperimentsApi {

    suspend operator fun invoke(
        experimentId: String,
        variantId: String,
        exposedAt: String,
    )
}
