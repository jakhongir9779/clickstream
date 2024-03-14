package analytics.sdk.clickstream.di

import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.ClickstreamSdkImpl
import analytics.sdk.clickstream.data.exposure.ExposureExperimentsApi
import analytics.sdk.clickstream.domain.gateway.ClickstreamRemoteGateway
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.database.ClickstreamDatabase
import analytics.sdk.database.gateway.LocalEventsGateway
import analytics.sdk.database.gateway.LocalEventsGatewayImpl
import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import android.content.Context
import org.koin.dsl.module

val AndroidKoinModule  = module {

}
