package analytics.sdk.clickstream

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.data.interactor.GetUnDispatchedEvents
import analytics.sdk.clickstream.data.interactor.SendBatchOfEventsToClickstream
import analytics.sdk.clickstream.di.ClickstreamSdkKoinContext
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import co.touchlab.kermit.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.withContext
import org.koin.core.Koin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class SendToAnalyticsPeriodicTask(
    context: Context,
    params: WorkerParameters,
) : CoroutineWorker(context, params), KoinComponent {

    val localEventsGateway by inject<LocalEventsGateway>()
    val remoteGateway by inject<ClickstreamRemoteGateway>()
    val clickstreamConfig by inject<ClickstreamConfig>()

    private val getUnDispatchedEvents by lazy {
        GetUnDispatchedEvents(localEventsGateway, clickstreamConfig)
    }

    private val sendBatchOfEventsToClickstream by lazy {
        SendBatchOfEventsToClickstream(localEventsGateway, remoteGateway, getUnDispatchedEvents)
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            while (getUnDispatchedEvents().isNotEmpty()) {
                try {
                    val sentResult = sendBatchOfEventsToClickstream()

                    if (sentResult.filterIsInstance<EventResult.Failed>().isNotEmpty()) {
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

    internal companion object {
        @Volatile
        private var INSTANCE: SendToAnalyticsPeriodicTask? = null

        @OptIn(InternalCoroutinesApi::class)
        internal fun get(
            context: Context,
            params: WorkerParameters,
        ): SendToAnalyticsPeriodicTask {
            synchronized(this) {
                val instance: SendToAnalyticsPeriodicTask?
                if (INSTANCE == null) {
                    instance = SendToAnalyticsPeriodicTask(context, params)
                    INSTANCE = instance
                }
                return INSTANCE!!
            }
        }
    }

    override fun getKoin(): Koin = ClickstreamSdkKoinContext.koin

}
