package analytics.sdk.clickstream.data.interactor

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.domain.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway

class SendBatchOfEventsToClickstream(
    private val localEventsGateway: LocalEventsGateway,
    private val clickstreamRemoteGateway: ClickstreamRemoteGateway,
    private val getUnDispatchedEvents: GetUnDispatchedEvents,
) {
    suspend operator fun invoke() : List<EventResult> {
        val sentResult = clickstreamRemoteGateway.send(getUnDispatchedEvents())

        val successResults = sentResult.filterIsInstance<EventResult.Succeed>()
        localEventsGateway.removeByIds(successResults.map { it.id })

        return sentResult
    }
}

