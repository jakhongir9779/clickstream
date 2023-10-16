package analytics.sdk.android

import analytics.sdk.common.AnalyticsJobScheduler
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
            url = "https://nexus.infra.cluster.kznexpess.com/repository/clickstream/",
            propertiesProvider = null,
            analyticsJobScheduler = AnalyticsJobScheduler(applicationContext),
            dependencies = AndroidDependencies(
                appVersion = "1.0.0",
                packageName = packageName,
                context = applicationContext,
            ),
        )
    }
    override fun getWorkManagerConfiguration(): Configuration {
        val myWorkerFactory = DelegatingWorkerFactory()

        myWorkerFactory.addFactory(
            AnalyticsSdkWorkerFactory(ClickstreamSdk.getInstance().getDataForWorker())
        )

        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .setWorkerFactory(myWorkerFactory)
            .build()
    }
}