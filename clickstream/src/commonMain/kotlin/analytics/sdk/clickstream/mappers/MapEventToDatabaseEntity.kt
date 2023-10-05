package analytics.sdk.clickstream.mappers

//import com.squareup.moshi.JsonAdapter
import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.properties.EventProperties
import analytics.sdk.clickstream.data.model.ConnectionType
import analytics.sdk.clickstream.data.model.Event
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.clickstream.properties.EventPropertiesDelegate
import analytics.sdk.clickstream.properties.PropertiesProvider
import analytics.sdk.database.model.EventSnapshotEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class MapEventToDatabaseEntity(
    private val propertiesProvider: PropertiesProvider,
    private val eventPropertiesDelegate: EventPropertiesDelegate,
    private val timestamp: () -> Long,
    private val isWifiConnection: () -> Boolean,
) {

    operator fun invoke(event: ClickstreamEvent): EventSnapshotEntity {
        val properties = propertiesProvider.toMapWithJsonValues()
        val propertiesHash = properties.hashCode().toString()

        val jsonEvent = populateEvent(event)

        return EventSnapshotEntity(
            event = jsonEvent,
            properties = properties,
            propertyHash = propertiesHash,
        )
    }


    private fun populateEvent(clickStreamEvent: ClickstreamEvent): String {
        val shouldIncrementCounter =
            clickStreamEvent.uiProperties?.action == UiProperties.Action.SPACE_OPEN
        val eventAdditionalProperties = eventPropertiesDelegate.get(shouldIncrementCounter)

        val uiProperties = clickStreamEvent.uiProperties?.let {
            val (viewId, previousViewId) = eventPropertiesDelegate.getViewId()
            it.toDb(viewId, previousViewId)
        }

        val event = Event(
            counter = eventAdditionalProperties.counter,
            time_zone = eventAdditionalProperties.timeZone,
            ui_properties = uiProperties,
            timestamp = timestamp(),
            event_properties = clickStreamEvent.eventProperties?.toDb(),
            connection_type = if (isWifiConnection()) ConnectionType.WIFI else ConnectionType.CELL,
            is_interactive = clickStreamEvent.isInteractive
        )

        return Json.encodeToString(event)
    }

    private fun EventProperties.toDb(): analytics.sdk.clickstream.data.model.EventProperties =
        analytics.sdk.clickstream.data.model.EventProperties(
            eventType = type,
            eventParameters = parameters
        )
}
