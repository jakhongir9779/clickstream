package analytics.sdk.clickstream.data.database

import analytics.sdk.clickstream.data.database.entity.EventSnapshotEntity
import analytics.sdk.clickstream.gateway.LocalEventsGateway
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        EventSnapshotEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(TypeConverter::class)
internal abstract class ClickstreamDatabase : RoomDatabase() {

    abstract fun events(): LocalEventsGateway

    companion object {

        private const val DATABASE_NAME = "clickstream.db"

        @Volatile
        private var INSTANCE: ClickstreamDatabase? = null

        fun get(context: Context): ClickstreamDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            ClickstreamDatabase::class.java,
                            DATABASE_NAME,
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
