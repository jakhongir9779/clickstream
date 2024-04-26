package analytics.sdk.database.gateway

import analytics.sdk.database.model.DbEventEntity

interface LocalEventsGateway {

    fun save(event: DbEventEntity)

    fun getAllByCount(count: Int): List<DbEventEntity>

    fun removeByIds(ids: List<Long>)
}
