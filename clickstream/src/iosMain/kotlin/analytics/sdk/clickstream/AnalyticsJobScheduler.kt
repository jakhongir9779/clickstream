package analytics.sdk.clickstream

import analytics.sdk.clickstream.data.DataForPeriodicJob
import analytics.sdk.clickstream.data.interactor.GetUnDispatchedEvents
import analytics.sdk.clickstream.data.interactor.SendBatchOfEventsToClickstream
import analytics.sdk.clickstream.domain.ClickstreamConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

actual class AnalyticsJobScheduler {

    private lateinit var getUnDispatchedEvents: GetUnDispatchedEvents
    private lateinit var sendBatchOfEventsToClickstream: SendBatchOfEventsToClickstream
    private lateinit var data: DataForPeriodicJob
    private var job: Job? = null

    actual fun init(clickStreamConfig: ClickstreamConfig) {
        data = Clickstream.instance.getDataForPeriodicJob()
        getUnDispatchedEvents = GetUnDispatchedEvents(
            data.localEventsGateway,
            data.clickstreamConfig,
        )
        sendBatchOfEventsToClickstream = SendBatchOfEventsToClickstream(
            data.localEventsGateway,
            data.remoteGateway,
            getUnDispatchedEvents,
        )
    }

    actual fun startWork(coroutineScope: CoroutineScope) {
        if (job == null) {
            job = coroutineScope.launch {
                while (isActive) {
                    if (getUnDispatchedEvents().isNotEmpty()) {
                        sendBatchOfEventsToClickstream()
                    }
                    delay((data.clickstreamConfig.sendDataPeriodicityInMinutes * 60 * 1000).toLong())
                }
            }
        }
    }
}
