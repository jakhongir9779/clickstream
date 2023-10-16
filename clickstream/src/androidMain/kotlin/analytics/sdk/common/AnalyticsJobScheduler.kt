package analytics.sdk.common

import analytics.sdk.clickstream.ClickstreamConfig
import analytics.sdk.clickstream.SendToAnalyticsPeriodicTask
import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

actual class AnalyticsJobScheduler(private val context: Context) {
    private var periodicRequest : WorkRequest? = null
    actual fun init(clickStreamConfig: ClickstreamConfig) {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        periodicRequest =
            PeriodicWorkRequestBuilder<SendToAnalyticsPeriodicTask>(
                repeatInterval = clickStreamConfig.sendDataPeriodicityInMinutes,
                repeatIntervalTimeUnit = TimeUnit.MINUTES
            )
                .setConstraints(constraints).build()

    }

    actual fun startWork() {
        when(periodicRequest) {
            is PeriodicWorkRequest -> {
                WorkManager.getInstance(context)
                    .enqueueUniquePeriodicWork(
                        "uniqueWorkName",
                        ExistingPeriodicWorkPolicy.KEEP,
                        periodicRequest as PeriodicWorkRequest
                    )
            }

            is OneTimeWorkRequest -> {
                WorkManager.getInstance(context)
                    .enqueueUniqueWork(
                        "uniqueWorkName",
                        ExistingWorkPolicy.KEEP,
                        periodicRequest as OneTimeWorkRequest
                    )
            }
        }

    }
}