package analytics.sdk.clickstream.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
internal enum class ConnectionType {
    @Json(name = "WIFI")
    WIFI,

    @Json(name = "CELL")
    CELL,

    @Json(name = "UNKNOWN")
    UNKNOWN,
}
