package analytics.sdk.clickstream.domain.gateway

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.database.model.DbEventEntity

 interface ClickstreamRemoteGateway {
    suspend fun send(events: List<DbEventEntity>): List<EventResult>
}
