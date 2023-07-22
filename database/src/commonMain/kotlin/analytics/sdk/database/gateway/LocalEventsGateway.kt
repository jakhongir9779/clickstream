package analytics.sdk.database.gateway

import analytics.sdk.database.model.EventSnapshotEntity

interface LocalEventsGateway {

    fun save(event: EventSnapshotEntity)

    fun getAllByCount(count: Int): List<EventSnapshotEntity>

    fun removeByIds(ids: List<Long>)
}
