package analytics.sdk.clickstream.mappers

import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.properties.EventProperties
import analytics.sdk.clickstream.data.model.ConnectionType
import analytics.sdk.clickstream.data.model.Event
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.database.model.DbEventEntity
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

    operator fun invoke(event: ClickstreamEvent): DbEventEntity {
        val properties = propertiesProvider.toMapWithJsonValues()
        val propertiesHash = properties.hashCode().toString()

        val jsonEvent = populateEvent(event)

        return DbEventEntity(
            event = jsonEvent,
            properties = properties,
            propertyHash = propertiesHash,
        )
    }


    private fun populateEvent(clickStreamEvent: ClickstreamEvent): String {
        val shouldIncrementCounter =
            clickStreamEvent.uiProperties?.action == UiProperties.Action.SPACE_OPEN
        val eventAdditionalProperties = eventPropertiesDelegate.get(shouldIncrementCounter)

        val uiProperties = clickStreamEvent.uiProperties?.let { uiProps ->
            val screenResolution = propertiesProvider.deviceProps.properties()
                .find { it.key == "screen_resolution" }
                ?.getValue()
                ?: ""
            val (viewId, previousViewId) = eventPropertiesDelegate.getViewId()
            uiProps.toDb(viewId, previousViewId, screenResolution)
        }

        val event = Event(
            counter = eventAdditionalProperties.counter,
            timeZone = eventAdditionalProperties.timeZone,
            uiProperties = uiProperties,
            timestamp = dependencies.utils.generateTimestamp(),
            eventProperties = clickStreamEvent.eventProperties?.toDb(),
            isInteractive = clickStreamEvent.isInteractive,
            connectionType = when (dependencies.utils.getConnectionType()) {
                PlatformConnectionType.WIFI -> ConnectionType.WIFI
                PlatformConnectionType.CELLULAR -> ConnectionType.CELL
                PlatformConnectionType.UNKNOWN -> ConnectionType.UNKNOWN
            },
        )

        return Json.encodeToString(event)
    }

    private fun EventProperties.toDb(): analytics.sdk.clickstream.data.model.EventProperties =
        analytics.sdk.clickstream.data.model.EventProperties(
            event_type = type,
            event_parameters = parameters
        )
}
