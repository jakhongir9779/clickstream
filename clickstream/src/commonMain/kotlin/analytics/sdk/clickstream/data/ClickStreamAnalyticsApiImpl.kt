package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.exposure.ExposureExperiment
import analytics.sdk.common.extensions.postJson
import io.ktor.client.HttpClient
import io.ktor.client.request.header
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
        httpClient.postJson<Unit>("api/analytics/v2/events/validate") {
            header("Authorization", "Bearer eyJraWQiOiIwcE9oTDBBVXlWSXF1V0w1U29NZTdzcVNhS2FqYzYzV1N5THZYb0ZhWXRNIiwiYWxnIjoiRWREU0EiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJVenVtIElEIiwiaWF0IjoxNjk4MTQ3NDUyLCJzdWIiOiI3MDRjNzczMC02NDM0LTQwMzctYTVkNS04YzZmZDE1NTY0MmUiLCJhdWQiOlsidXp1bV9hcHBzIiwibWFya2V0L2FuZHJvaWQiXSwiZXZlbnRzIjp7Im90cF9wYXNzZWQiOjE2OTc2MTIzMDN9LCJjdXN0b21lcl9pZCI6IjYyNTM2ZGIyLTVjZWUtNDcwZC1iNmM2LWY4MWY3YzAzMzYzOCIsInBob25lX251bWJlciI6Ijk5ODU1MDAxMTExMSIsImV4cCI6MTY5ODE1MDQ1Mn0.XXnwVmFbcZt1QhbGKSpk4RRrAS-ULpRKKU1eRcLTemVGkQHpTuQAa0nzLVDqIYv6qs4PDteP-esO0w-9GZ_ODA")
            setBody(body)
        }
    }

    override suspend fun exposureExperiments(body: ExposureExperiment) {
        httpClient.postJson<Unit>("experiments/exposure") {
            setBody(body)
        }
    }
}
