package analytics.sdk.database.mapper

import analytics.sdk.database.Event
import analytics.sdk.database.model.DbEventEntity

internal fun DbEventEntity.toLocalModel() = Event(
    id = id,
    eventJson = event,
    propertiesMapJson = properties,
    propertiesHash = propertyHash,
)

internal fun Event.toPublicModel() = DbEventEntity(
    id = id,
    event = eventJson,
    properties = propertiesMapJson,
    propertyHash = propertiesHash,
)
