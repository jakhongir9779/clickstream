package analytics.sdk.database.gateway

import analytics.sdk.database.EventSnapshotQueries
import analytics.sdk.database.mapper.toLocalModel
import analytics.sdk.database.mapper.toPublicModel
import analytics.sdk.database.model.EventSnapshotEntity

internal class LocalEventsGatewayImpl(
    private val queries: EventSnapshotQueries
) : LocalEventsGateway {

    override fun save(event: EventSnapshotEntity) {
        queries.save(event.toLocalModel())
    }

    override fun getAllByCount(count: Int): List<EventSnapshotEntity> {
        return queries.getAllByCount(count.toLong())
            .executeAsList()
            .map { it.toPublicModel() }
    }

    override fun removeByIds(ids: List<Long>) {
        queries.removeByIds(ids)
    }
}
