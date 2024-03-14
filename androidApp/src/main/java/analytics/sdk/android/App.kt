package analytics.sdk.android

import analytics.sdk.clickstream.AnalyticsSdkWorkerFactory
import analytics.sdk.clickstream.Clickstream
import analytics.sdk.clickstream.initialize
import analytics.sdk.properties.PropertiesProvider
import analytics.sdk.properties.application.ApplicationAnalyticsPropertyProvider
import analytics.sdk.properties.device.DeviceAnalyticsPropertyProvider
import analytics.sdk.properties.device.default.AppMetricaDeviceIdProperty
import analytics.sdk.properties.user.UserAnalyticsPropertyProvider
import analytics.sdk.properties.user.default.AccountIdProperty
import analytics.sdk.properties.user.default.AppsflyerIdProperty
import analytics.sdk.properties.user.default.FacebookIdProperty
import analytics.sdk.properties.user.default.FirebaseAppInstanceIdProperty
import analytics.sdk.properties.user.default.GoogleCidProperty
import analytics.sdk.properties.user.default.LanguageProperty
import analytics.sdk.properties.user.default.MindboxAnonIdProperty
import analytics.sdk.properties.user.default.MindboxIdProperty
import analytics.sdk.properties.user.default.MyTrackerInstanceIdProperty
import android.app.Application
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory


class App : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()

        val header = "Bearer eyJraWQiOiIwcE9oTDBBVXlWSXF1V0w1U29NZTdzcVNhS2FqYzYzV1N5THZYb0ZhWXR" +
                "NIiwiYWxnIjoiRWREU0EiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJVenVtIElEIiwiaWF0IjoxNjk4MTQ" +
                "3NDUyLCJzdWIiOiI3MDRjNzczMC02NDM0LTQwMzctYTVkNS04YzZmZDE1NTY0MmUiLCJhdWQiOlsidX" +
                "p1bV9hcHBzIiwibWFya2V0L2FuZHJvaWQiXSwiZXZlbnRzIjp7Im90cF9wYXNzZWQiOjE2OTc2MTIzM" +
                "DN9LCJjdXN0b21lcl9pZCI6IjYyNTM2ZGIyLTVjZWUtNDcwZC1iNmM2LWY4MWY3YzAzMzYzOCIsInBo" +
                "b25lX251bWJlciI6Ijk5ODU1MDAxMTExMSIsImV4cCI6MTY5ODE1MDQ1Mn0.XXnwVmFbcZt1QhbGKSp" +
                "k4RRrAS-ULpRKKU1eRcLTemVGkQHpTuQAa0nzLVDqIYv6qs4PDteP-esO0w-9GZ_ODA"

        Clickstream.initialize(
            context = applicationContext,
            url = "https://clickstream-b2c.dev.cluster.kznexpess.com/api/analytics/v2/",
            requestHeaders = mapOf("Authorization" to { header }),
            propertiesProvider = PropertiesProvider(
                appProps = ApplicationAnalyticsPropertyProvider(
                    setOf(
                        //AppVersionProperty("app_version")
                    )
                ),
                deviceProps = DeviceAnalyticsPropertyProvider(
                    setOf(
                        AppMetricaDeviceIdProperty("appmetrica_device_id")
                    )
                ),
                userProps = UserAnalyticsPropertyProvider(
                    setOf(
                        //InstallIdProperty("install_id"),
                        AccountIdProperty("account_id"),
                        AppsflyerIdProperty("appsflyer_id"),
                        FacebookIdProperty("facebook_id"),
                        FirebaseAppInstanceIdProperty("firebase_app_instance_id"),
                        GoogleCidProperty("google_cid"),
                        LanguageProperty("language"),
                        MindboxAnonIdProperty("mindbox_anon_id"),
                        MindboxIdProperty("mindbox_id"),
                        MyTrackerInstanceIdProperty("mytracker_id"),
                    )
                )
            )
        )
    }

    override fun getWorkManagerConfiguration(): Configuration {
        val myWorkerFactory = DelegatingWorkerFactory()

        myWorkerFactory.addFactory(
            AnalyticsSdkWorkerFactory(Clickstream.getDataForPeriodicJob())
        )

        return Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(myWorkerFactory)
            .build()
    }
}
