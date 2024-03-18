package analytics.sdk.clickstream.di

import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApiImpl
import analytics.sdk.clickstream.data.gateway.ClickstreamRemoteGatewayImpl
import analytics.sdk.clickstream.domain.gateway.ClickstreamRemoteGateway
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val NetworkModule = module {
    single<ClickstreamAnalyticsApi> { params ->
        val httpClient = buildHttpClient(params.get(), params.get())
        ClickstreamAnalyticsApiImpl(httpClient)
    }
    single<ClickstreamRemoteGateway> {
        ClickstreamRemoteGatewayImpl(get())
    }
}

private fun buildHttpClient(
    headers: Map<String, () -> String>,
    baseUrl: String
): HttpClient = HttpClient {
    expectSuccess = true
    defaultRequest {
        url(baseUrl)
        headers.forEach { (key, value) ->
            header(key, value)
        }
    }
    install(Logging) {
        level = LogLevel.ALL
        logger = object : Logger {
            override fun log(message: String) {
                co.touchlab.kermit.Logger.i { message }
            }
        }
    }
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }
}


