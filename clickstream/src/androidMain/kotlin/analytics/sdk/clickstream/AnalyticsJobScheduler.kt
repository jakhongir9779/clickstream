package analytics.sdk.clickstream

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
    private var request : WorkRequest? = null
    actual fun init(clickStreamConfig: ClickstreamConfig) {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        request = PeriodicWorkRequestBuilder<SendToAnalyticsPeriodicTask>(
                repeatInterval = clickStreamConfig.sendDataPeriodicityInMinutes,
                repeatIntervalTimeUnit = TimeUnit.MINUTES
            )
                .setConstraints(constraints).build()

    }

    actual fun startWork() {
        when(request) {
            is PeriodicWorkRequest -> {
                WorkManager.getInstance(context)
                    .enqueueUniquePeriodicWork(
                        AnalyticsJobScheduler::class.java.name,
                        ExistingPeriodicWorkPolicy.KEEP,
                        request as PeriodicWorkRequest
                    )


            }

            is OneTimeWorkRequest -> {
                WorkManager.getInstance(context)
                    .enqueueUniqueWork(
                        "${AnalyticsJobScheduler::class.java.name}.debugVersion",
                        ExistingWorkPolicy.REPLACE,
                        request as OneTimeWorkRequest
                    )
            }
        }

    }
}