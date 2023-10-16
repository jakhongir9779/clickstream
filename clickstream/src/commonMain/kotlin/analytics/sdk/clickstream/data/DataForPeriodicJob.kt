package analytics.sdk.clickstream.data

import analytics.sdk.clickstream.ClickstreamConfig
import analytics.sdk.clickstream.gateway.ClickstreamRemoteGateway
import analytics.sdk.database.gateway.LocalEventsGateway

data class DataForPeriodicJob(
    val localEventsGateway: LocalEventsGateway,
    val remoteGateway: ClickstreamRemoteGateway,
    val clickstreamConfig: ClickstreamConfig
)