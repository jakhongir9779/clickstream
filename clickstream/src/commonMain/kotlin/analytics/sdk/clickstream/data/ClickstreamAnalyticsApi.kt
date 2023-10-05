package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.exposure.ExposureExperiment

internal interface ClickstreamAnalyticsApi {

    suspend fun sendEvents(body: String)

    suspend fun sendEventsTest(body: String)

    suspend fun exposureExperiments(body: ExposureExperiment)
}
