package analytics.sdk.database

import analytics.sdk.database.gateway.LocalEventsGateway
import analytics.sdk.database.gateway.LocalEventsGatewayImpl
import app.cash.sqldelight.ColumnAdapter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ClickstreamDatabase(driverFactory: DriverFactory) {

    private val database = Database(
        driver = driverFactory.createDriver(),
        event_snapshotAdapter = Event_snapshot.Adapter(
            event_jsonAdapter = jsonAdapter(),
            properties_map_jsonAdapter = jsonAdapter()
        )
    )

    fun events(): LocalEventsGateway = LocalEventsGatewayImpl(database.eventSnapshotQueries)

    private inline fun <reified T : Any> jsonAdapter() = object : ColumnAdapter<T, String> {
        override fun decode(databaseValue: String): T = Json.decodeFromString(databaseValue)
        override fun encode(value: T): String = Json.encodeToString(value)
    }
}
