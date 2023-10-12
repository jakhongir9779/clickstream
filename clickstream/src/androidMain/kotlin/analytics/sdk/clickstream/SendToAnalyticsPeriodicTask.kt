package analytics.sdk.clickstream

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import co.touchlab.kermit.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.withContext
import kotlin.jvm.Volatile

internal class SendToAnalyticsPeriodicTask(
    context: Context,
    params: WorkerParameters,
    private val localEventsGateway: LocalEventsGateway,
    private val clickstreamRemoteGateway: ClickstreamRemoteGateway,
    private val clickstreamConfig: ClickstreamConfig
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            while (haveUnDispatchedData()) {
                try {
                    val eventsToSend = localEventsGateway.getAllByCount(clickstreamConfig.sizeOfBatch)

                    val sentResult = clickstreamRemoteGateway.send(eventsToSend)

                    val failedResults = sentResult.filterIsInstance<EventResult.Failed>()
                    val successResults = sentResult.filterIsInstance<EventResult.Succeed>()

                    localEventsGateway.removeByIds(successResults.map { it.id })

                    if (failedResults.isNotEmpty()) {
                        return@withContext Result.retry()
                    }
                } catch (e: Exception) {
                    Logger.e(e) { "AnalyticsDispatchWorker failed with error" }
                    return@withContext Result.retry()
                }
            }
            return@withContext Result.success()
        } catch (e: Exception) {
            Logger.e(e) { "AnalyticsDispatchWorker failed trying to check count of events" }
            return@withContext Result.retry()
        }
    }

    private fun haveUnDispatchedData(): Boolean =
        localEventsGateway.getAllByCount(clickstreamConfig.sizeOfBatch).isNotEmpty()

    internal companion object {
        @Volatile
        private var INSTANCE: SendToAnalyticsPeriodicTask? = null

        @OptIn(InternalCoroutinesApi::class)
        internal fun get(
            context: Context,
            params: WorkerParameters,
            localEventsGateway: LocalEventsGateway,
            clickStreamRemoteGateway: ClickstreamRemoteGateway,
            clickstreamConfig: ClickstreamConfig
        ): SendToAnalyticsPeriodicTask {
            synchronized(this) {
                val instance: SendToAnalyticsPeriodicTask?

                if (INSTANCE == null) {
                    instance =
                        SendToAnalyticsPeriodicTask(
                            context,
                            params,
                            localEventsGateway,
                            clickStreamRemoteGateway,
                            clickstreamConfig
                        )
                    INSTANCE = instance
                }

                return INSTANCE!!
            }
        }
    }
}
