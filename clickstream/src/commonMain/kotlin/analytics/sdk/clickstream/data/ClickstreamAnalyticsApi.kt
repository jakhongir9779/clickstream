package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.exposure.ExposureExperiment
//import retrofit2.Response
//import retrofit2.http.Body
//import retrofit2.http.Headers
//import retrofit2.http.POST

internal interface ClickstreamAnalyticsApi {

//    @POST("events")
//    @Headers("Content-Type: application/json")
    suspend fun sendEvents(
        /*/*@Body*/*/ body: String
    )

//    @POST("events/validate")
//    @Headers("Content-Type: application/json")
    suspend fun sendEventsTest(
        /*@Body*/ body: String
    )

//    @POST("experiments/exposure")
//    @Headers("Content-Type: application/json")
    suspend fun exposureExperiments(
        /*@Body*/ body: ExposureExperiment
    )
}
