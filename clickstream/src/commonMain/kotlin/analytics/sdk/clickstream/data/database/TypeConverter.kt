package analytics.sdk.clickstream.data.database

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

internal class TypeConverter {
    @TypeConverter
    fun fromMapType(value: String): Map<String, String>? {
        val type = Types.newParameterizedType(
            MutableMap::class.java,
            String::class.java,
            String::class.java
        )
        return Moshi.Builder().build().adapter<Map<String, String>>(type).fromJson(value)
    }

    @TypeConverter
    fun fromString(map: Map<String, String>): String {
        val type = Types.newParameterizedType(
            MutableMap::class.java,
            String::class.java,
            String::class.java
        )
        return Moshi.Builder().build().adapter<Map<String, String>>(type).toJson(map)
    }
}
