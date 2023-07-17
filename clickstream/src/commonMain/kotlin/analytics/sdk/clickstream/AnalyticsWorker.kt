package analytics.sdk.clickstream

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.clickstream.gateway.LocalEventsGateway
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

internal class AnalyticsWorker(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val localEventsGateway: LocalEventsGateway,
    private val clickstreamRemoteGateway: ClickstreamRemoteGateway,
    private val clickstreamConfig: ClickstreamConfig,
) {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(
            Exception(
                "AnalyticsWorker", throwable
            )
        )
    }

    private val coroutineScope = CoroutineScope(
        SupervisorJob() + dispatcher + coroutineExceptionHandler
    )

    private val backoffStrategy =
        ExponentialBackoffStrategy(
            maxRetries = 8,
            initialDelayMillis = TimeUnit.SECONDS.toMillis(5)
        )

    fun doWork() {
        coroutineScope.launch(dispatcher) {
            // temporary while true loop instead of worker or KMM solution
            while (true) {
                try {
                    while (haveUnDispatchedData()) {
                        try {
                            delay(clickstreamConfig.delayInSeconds)
                            val eventsToSend =
                                localEventsGateway.getAllByCount(clickstreamConfig.sizeOfBatch)

                            val sentResult = clickstreamRemoteGateway.send(eventsToSend)

                            val failedResults = sentResult.filterIsInstance<EventResult.Failed>()
                            val successResults = sentResult.filterIsInstance<EventResult.Succeed>()

                            localEventsGateway.removeByIds(successResults.map { it.id })

                            if (failedResults.isEmpty()) {
                                backoffStrategy.dropBackoff()
                            } else {
                                delay(backoffStrategy.getMillis())
                            }
                        } catch (e: Exception) {
                            Timber.e(Exception("AnalyticsDispatchWorker failed with error", e))
                            delay(backoffStrategy.getMillis())
                        }
                    }
                } catch (e: Exception) {
                    Timber.e(
                        Exception(
                            "AnalyticsDispatchWorker failed trying to check count of events",
                            e
                        )
                    )
                    delay(backoffStrategy.getMillis())
                }
            }
        }
    }

    private suspend fun haveUnDispatchedData(): Boolean =
        localEventsGateway.getAllByCount(clickstreamConfig.sizeOfBatch).isNotEmpty()

    internal companion object {
        @Volatile
        private var INSTANCE: AnalyticsWorker? = null

        internal fun get(
            localEventsGateway: LocalEventsGateway,
            clickStreamRemoteGateway: ClickstreamRemoteGateway,
            clickStreamConfig: ClickstreamConfig,
        ): AnalyticsWorker {
            synchronized(this) {
                var instance: AnalyticsWorker? = null

                if (INSTANCE == null) {
                    instance =
                        AnalyticsWorker(
                            Dispatchers.IO,
                            localEventsGateway,
                            clickStreamRemoteGateway,
                            clickStreamConfig,
                        )
                    INSTANCE = instance
                }

                return INSTANCE.also { it?.doWork() }!!
            }
        }
    }
}
