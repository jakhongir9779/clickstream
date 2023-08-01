package analytics.sdk.clickstream

import analytics.sdk.AnalyticsType
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.clickstream.mappers.MapEventToDatabaseEntity
import analytics.sdk.clickstream.type.Clickstream
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.database.gateway.LocalEventsGateway
import analytics.sdk.event.Event


internal class ClickstreamAnalyticsEventSender(
    private val localEventsGateway: LocalEventsGateway,
    private val mapEventToDatabaseEntity: MapEventToDatabaseEntity,
) : AnalyticsEventSender {

    override val type: AnalyticsType = Clickstream

    override suspend fun send(event: Event) {
        try {
            require(event is ClickstreamEvent)
            localEventsGateway.save(mapEventToDatabaseEntity(event))
        } catch (e: Exception) {
//            Timber.e(Exception("Error while trying to save to database", e))
        }
    }
}
