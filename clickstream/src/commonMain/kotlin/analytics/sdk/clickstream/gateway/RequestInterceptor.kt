package analytics.sdk.clickstream.gateway

import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor(
    private val requestHeaders: Map<String, () -> String>
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (requestHeaders.isEmpty()) return chain.proceed(chain.request())

        val request = chain.request()
        val newRequest = request.newBuilder()

        requestHeaders.forEach { (k, v) ->
            newRequest.addHeader(k, v())
        }

        return chain.proceed(newRequest.build())
    }

}
