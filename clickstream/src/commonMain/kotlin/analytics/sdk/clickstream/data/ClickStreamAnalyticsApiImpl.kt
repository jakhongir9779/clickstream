package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.exposure.ExposureExperiment
import analytics.sdk.common.extensions.postJson
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class ClickStreamAnalyticsApiImpl(private val httpClient: HttpClient) :
    ClickstreamAnalyticsApi {

    override suspend fun sendEvents(body: String) {
        httpClient.postJson<Unit>("events") {
            setBody(body)
        }
    }

    override suspend fun sendEventsTest(body: String) {
        httpClient.postJson<Unit>("events/validate") {
            setBody(body)
        }
    }

    override suspend fun exposureExperiments(body: ExposureExperiment) {
        httpClient.postJson<Unit>("experiments/exposure") {
            setBody(body)
        }
    }
}
