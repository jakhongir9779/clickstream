package analytics.sdk.clickstream.data.interactor

import analytics.sdk.clickstream.ClickstreamConfig
import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway

class SendBatchOfEventsToClickstream(
    private val localEventsGateway: LocalEventsGateway,
    private val clickstreamRemoteGateway: ClickstreamRemoteGateway,
    private val clickstreamConfig: ClickstreamConfig
) {
    suspend operator fun invoke() : List<EventResult> {
        val eventsToSend = localEventsGateway.getAllByCount(clickstreamConfig.sizeOfBatch)

        val sentResult = clickstreamRemoteGateway.send(eventsToSend)

        val successResults = sentResult.filterIsInstance<EventResult.Succeed>()
        localEventsGateway.removeByIds(successResults.map { it.id })

        return sentResult
    }
}

