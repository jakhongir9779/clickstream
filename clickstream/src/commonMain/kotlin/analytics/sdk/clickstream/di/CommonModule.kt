package analytics.sdk.clickstream.di

import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.ClickstreamSdkImpl
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.common.extensions.MultiParameter
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider
import org.koin.dsl.module

val CommonKoinModule = module {

    factory<ClickstreamSdkImpl> { (parameters: MultiParameter) ->
        val (
            url: String,
            dependencies: PlatformDependencies,
            requestHeaders: Map<String, () -> String>,
            clickStreamConfig: ClickstreamConfig,
            analyticsJobScheduler: AnalyticsJobScheduler,
            propertiesProvider: PropertiesProvider?
        ) = parameters

        ClickstreamSdkImpl(
            url = url,
            dependencies = dependencies,
            requestHeaders = requestHeaders,
            clickStreamConfig = clickStreamConfig,
            analyticsJobScheduler = analyticsJobScheduler,
            propertiesProvider = propertiesProvider
        )
    }

}

