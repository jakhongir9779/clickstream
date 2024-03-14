package analytics.sdk.database.gateway

import analytics.sdk.database.Database
import analytics.sdk.database.mapper.toPublicModel
import analytics.sdk.database.model.DbEventEntity

class LocalEventsGatewayImpl(
    private val clickStreamDatabase: Database,
) : LocalEventsGateway {

    override fun save(event: DbEventEntity) {
        clickStreamDatabase.eventEntityQueries.save(null, event.event, event.properties, event.propertyHash)
    }

    override fun getAllByCount(count: Int): List<DbEventEntity> {
        return clickStreamDatabase.eventEntityQueries.getAllByCount(count.toLong())
            .executeAsList()
            .map { it.toPublicModel() }
    }

    override fun removeByIds(ids: List<Long>) {
        clickStreamDatabase.eventEntityQueries.removeByIds(ids)
    }
}
