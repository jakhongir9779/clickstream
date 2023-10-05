package analytics.sdk.database.mapper

import analytics.sdk.database.Event_snapshot
import analytics.sdk.database.model.EventSnapshotEntity

internal fun EventSnapshotEntity.toLocalModel() = Event_snapshot(
    id = id,
    event_json = event,
    properties_map_json = properties,
    properties_hash = propertyHash,
)

internal fun Event_snapshot.toPublicModel() = EventSnapshotEntity(
    id = id,
    event = event_json,
    properties = properties_map_json,
    propertyHash = properties_hash,
)
