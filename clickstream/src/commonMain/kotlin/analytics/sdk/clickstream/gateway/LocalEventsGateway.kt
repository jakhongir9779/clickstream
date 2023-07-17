package analytics.sdk.clickstream.gateway

import analytics.sdk.clickstream.data.database.entity.EventSnapshotEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
internal interface LocalEventsGateway {
    @Insert
    suspend fun save(event: EventSnapshotEntity)

    /**
     * Get all items
     */
    @Query("SELECT * FROM event_snapshot LIMIT :count")
    suspend fun getAllByCount(count: Int): List<EventSnapshotEntity>

    /**
     * Pass ids with format: 1,2,3,4
     */
    @Query("DELETE FROM event_snapshot WHERE id IN (:ids);")
    suspend fun removeByIds(ids: List<Long>)
}
