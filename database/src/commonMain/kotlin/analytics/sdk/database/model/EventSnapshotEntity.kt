package analytics.sdk.database.model

import kotlinx.serialization.json.Json

data class EventSnapshotEntity(
    val id: Long = 0,
    val event: Json,
    val properties: Map<String, String>,
    val propertyHash: String,
)
