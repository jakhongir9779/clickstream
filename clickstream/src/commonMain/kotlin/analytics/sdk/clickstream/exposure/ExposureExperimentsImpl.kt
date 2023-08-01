package analytics.sdk.clickstream.exposure

import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.properties.AnalyticsPropertyValue


internal class ExposureExperimentsImpl(
    private val api: ClickstreamAnalyticsApi,
    private val installId: AnalyticsPropertyValue,
) : ExposureExperimentsApi {

    override suspend fun invoke(
        experimentId: String,
        variantId: String,
        exposedAt: String,
    ) {
        try {
            api.exposureExperiments(
                ExposureExperiment(
                    experimentId = experimentId,
                    variantId = variantId,
                    exposedAt = exposedAt,
                    accountId = installId.getValue() ?: error("install id should be defined")
                )
            )
        } catch (e: Exception) {
//            Timber.e(Exception(e))
        }
    }
}
