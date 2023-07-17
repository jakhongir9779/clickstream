package analytics.sdk.clickstream.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_snapshot")
internal data class EventSnapshotEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "event_json")
    val eventJson: String,

    /**
     * key - key for json object
     * value - json values inside object
     * example: "app_props" : { "x": 5, "y": 6 }, "user_props" : { "y": 5 }, "anything" : { "x": 5 }
     */
    @ColumnInfo(name = "properties_map_json")
    val  properties: Map<String, String>,

    @ColumnInfo(name = "properties_hash")
    val propertyHash: String,
)
