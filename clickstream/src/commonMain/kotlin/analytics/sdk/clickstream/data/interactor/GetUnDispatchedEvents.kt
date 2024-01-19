package analytics.sdk.clickstream.data.interactor

import analytics.sdk.clickstream.ClickstreamConfig
import analytics.sdk.database.gateway.LocalEventsGateway
import analytics.sdk.database.model.EventSnapshotEntity

class GetUnDispatchedEvents(
    private val localEventsGateway: LocalEventsGateway,
    private val clickstreamConfig: ClickstreamConfig,
) {
    operator fun invoke(): List<EventSnapshotEntity> {
        return localEventsGateway.getAllByCount(clickstreamConfig.sizeOfBatch)
    }
}
