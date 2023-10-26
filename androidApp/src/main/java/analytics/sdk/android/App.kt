package analytics.sdk.android

import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.ClickstreamSdk
import analytics.sdk.clickstream.AnalyticsSdkWorkerFactory
import analytics.sdk.platform.AndroidDependencies
import android.app.Application
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory

class App: Application(), Configuration.Provider {
    override fun onCreate() {
        super.onCreate()
        ClickstreamSdk.initialize(
            url = "https://clickstream-b2c.dev.cluster.kznexpess.com",
            propertiesProvider = null,
            analyticsJobScheduler = AnalyticsJobScheduler(applicationContext),
            dependencies = AndroidDependencies(
                appVersion = "1.0.0",
                packageName = packageName,
                context = applicationContext,
            ),
        requestHeaders = mapOf("Authorization" to { "Bearer eyJraWQiOiIwcE9oTDBBVXlWSXF1V0w1U29NZTdzcVNhS2FqYzYzV1N5THZYb0ZhWXRNIiwiYWxnIjoiRWREU0EiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJVenVtIElEIiwiaWF0IjoxNjk4MTQ3NDUyLCJzdWIiOiI3MDRjNzczMC02NDM0LTQwMzctYTVkNS04YzZmZDE1NTY0MmUiLCJhdWQiOlsidXp1bV9hcHBzIiwibWFya2V0L2FuZHJvaWQiXSwiZXZlbnRzIjp7Im90cF9wYXNzZWQiOjE2OTc2MTIzMDN9LCJjdXN0b21lcl9pZCI6IjYyNTM2ZGIyLTVjZWUtNDcwZC1iNmM2LWY4MWY3YzAzMzYzOCIsInBob25lX251bWJlciI6Ijk5ODU1MDAxMTExMSIsImV4cCI6MTY5ODE1MDQ1Mn0.XXnwVmFbcZt1QhbGKSpk4RRrAS-ULpRKKU1eRcLTemVGkQHpTuQAa0nzLVDqIYv6qs4PDteP-esO0w-9GZ_ODA" },)
        )
    }
    override fun getWorkManagerConfiguration(): Configuration {
        val myWorkerFactory = DelegatingWorkerFactory()

        myWorkerFactory.addFactory(
            AnalyticsSdkWorkerFactory(ClickstreamSdk.getInstance().getDataForWorker())
        )

        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(myWorkerFactory)
            .build()
    }
}