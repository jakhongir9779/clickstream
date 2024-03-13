package analytics.sdk.database.mapper

import analytics.sdk.database.EventsTable
import analytics.sdk.database.model.DbEventEntity

internal fun DbEventEntity.toLocalModel() = EventsTable(
    id = id,
    eventJson = event,
    propertiesMapJson = properties,
    propertiesHash = propertyHash,
)

internal fun EventsTable.toPublicModel() = DbEventEntity(
    id = id,
    event = eventJson,
    properties = propertiesMapJson,
    propertyHash = propertiesHash,
)
