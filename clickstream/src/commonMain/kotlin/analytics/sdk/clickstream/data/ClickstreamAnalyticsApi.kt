package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.data.exposure.ExposureExperiment

interface ClickstreamAnalyticsApi {

    suspend fun sendEvents(body: String)

    suspend fun sendEventsTest(body: String)

    suspend fun exposureExperiments(body: ExposureExperiment)
}
