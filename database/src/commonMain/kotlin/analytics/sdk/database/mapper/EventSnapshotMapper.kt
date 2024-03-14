package analytics.sdk.database.mapper

import analytics.sdk.database.Event_entity
import analytics.sdk.database.model.DbEventEntity

internal fun DbEventEntity.toLocalModel() = Event_entity(
    id = id,
    eventJson = event,
    propertiesMapJson = properties,
    propertiesHash = propertyHash,
)

internal fun Event_entity.toPublicModel() = DbEventEntity(
    id = id,
    event = eventJson,
    properties = propertiesMapJson,
    propertyHash = propertiesHash,
)
