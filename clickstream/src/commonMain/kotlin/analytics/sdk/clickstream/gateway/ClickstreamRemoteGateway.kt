package analytics.sdk.clickstream.gateway

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.clickstream.data.database.entity.EventSnapshotEntity
import androidx.annotation.RestrictTo

@RestrictTo(value = [RestrictTo.Scope.LIBRARY])
internal interface ClickstreamRemoteGateway {
    suspend fun send(events: List<EventSnapshotEntity>): List<EventResult>
}
