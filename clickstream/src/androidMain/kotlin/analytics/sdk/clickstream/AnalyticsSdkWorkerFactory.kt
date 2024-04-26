package analytics.sdk.clickstream

import analytics.sdk.clickstream.interactors.SendToAnalyticsPeriodicTask
import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters

class AnalyticsSdkWorkerFactory : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            SendToAnalyticsPeriodicTask::class.java.name ->
                SendToAnalyticsPeriodicTask(appContext, workerParameters)

            else ->
                // Return null, so that the base class can delegate to the default WorkerFactory.
                null
        }
    }
}
