package analytics.sdk.clickstream.gateway

import analytics.sdk.clickstream.data.EventResult
import analytics.sdk.database.model.EventSnapshotEntity
//import androidx.annotation.RestrictTo

//@RestrictTo(value = [RestrictTo.Scope.LIBRARY])
 interface ClickstreamRemoteGateway {
    suspend fun send(events: List<EventSnapshotEntity>): List<EventResult>
}
