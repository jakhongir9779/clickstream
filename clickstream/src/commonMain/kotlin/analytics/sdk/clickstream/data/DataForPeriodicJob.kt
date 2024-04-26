package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway

data class DataForPeriodicJob(
    val localEventsGateway: LocalEventsGateway,
    val remoteGateway: ClickstreamRemoteGateway,
    val clickstreamConfig: ClickstreamConfig
)
