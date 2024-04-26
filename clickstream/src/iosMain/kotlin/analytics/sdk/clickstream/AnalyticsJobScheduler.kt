package analytics.sdk.clickstream

import analytics.sdk.clickstream.data.DataForPeriodicJob
import analytics.sdk.clickstream.data.interactor.GetUnDispatchedEvents
import analytics.sdk.clickstream.data.interactor.SendBatchOfEventsToClickstream
import analytics.sdk.clickstream.di.ClickstreamSdkIsolatedKoinComponent
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.koin.core.component.inject

actual class AnalyticsJobScheduler : ClickstreamSdkIsolatedKoinComponent() {

    private lateinit var getUnDispatchedEvents: GetUnDispatchedEvents
    private lateinit var sendBatchOfEventsToClickstream: SendBatchOfEventsToClickstream
    private lateinit var data: DataForPeriodicJob
    private var job: Job? = null

    val localEventsGateway by inject<LocalEventsGateway>()
    val remoteGateway by inject<ClickstreamRemoteGateway>()
    val clickstreamConfig by inject<ClickstreamConfig>()

    actual fun init(clickStreamConfig: ClickstreamConfig) {
        getUnDispatchedEvents = GetUnDispatchedEvents(localEventsGateway, clickstreamConfig)
        sendBatchOfEventsToClickstream = SendBatchOfEventsToClickstream(
            localEventsGateway,
            remoteGateway,
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
