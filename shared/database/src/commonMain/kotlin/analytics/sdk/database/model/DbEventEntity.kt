package analytics.sdk.database.model

import kotlinx.serialization.Serializable


@Serializable
data class  DbEventEntity(
    val id: Long = 0,
    val event: String,
    val properties: Map<String, String>,
    val propertyHash: String,
)
