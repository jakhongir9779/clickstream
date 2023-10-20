package analytics.sdk.clickstream.mappers

import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.properties.EventProperties
import analytics.sdk.clickstream.data.model.ConnectionType
import analytics.sdk.clickstream.data.model.Event
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.database.model.EventSnapshotEntity
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.platform.model.PlatformConnectionType
import analytics.sdk.platform.properties.EventPropertiesDelegate
import analytics.sdk.properties.PropertiesProvider
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal class MapEventToDatabaseEntity(
    private val dependencies: PlatformDependencies,
    private val propertiesProvider: PropertiesProvider,
    private val eventPropertiesDelegate: EventPropertiesDelegate,
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
            timestamp = dependencies.utils.generateTimestamp(),
            event_properties = clickStreamEvent.eventProperties?.toDb(),
            is_interactive = clickStreamEvent.isInteractive,
            connection_type = when (dependencies.utils.getConnectionType()) {
                PlatformConnectionType.WIFI -> ConnectionType.WIFI
                PlatformConnectionType.CELLULAR -> ConnectionType.CELL
                PlatformConnectionType.UNKNOWN -> ConnectionType.UNKNOWN
            },
        )

        return Json.encodeToString(event)
    }

    private fun EventProperties.toDb(): analytics.sdk.clickstream.data.model.EventProperties =
        analytics.sdk.clickstream.data.model.EventProperties(
            eventType = type,
            eventParameters = parameters
        )
}
