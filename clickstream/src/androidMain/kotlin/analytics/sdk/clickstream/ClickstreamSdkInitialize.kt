package analytics.sdk.clickstream

import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider
import android.content.Context
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.inject

// Initialize for Android
fun ClickstreamSdkImpl.initialize(
    context: Context,
    url: String,
    requestHeaders: Map<String, () -> String>,
    config: ClickstreamConfig = ClickstreamConfig(),
    propertiesProvider: PropertiesProvider? = null,
) : KoinComponent {
    // loadKoinModules

    val dependencies : PlatformDependencies by inject(clazz = PlatformDependencies::class.java) {
        parametersOf(context)
    }

    initialize(
        url = url,
        dependencies = dependencies,
        propertiesProvider = propertiesProvider,
        config = config,
        requestHeaders = requestHeaders,
        analyticsJobScheduler = AnalyticsJobScheduler(context),
    )
}
