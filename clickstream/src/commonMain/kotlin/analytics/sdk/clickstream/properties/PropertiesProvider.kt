package analytics.sdk.clickstream.properties

import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.device.DeviceAnalyticsPropertyProvider
import analytics.sdk.clickstream.properties.user.UserAnalyticsPropertyProvider
import kotlinx.serialization.Serializable

@Serializable
class PropertiesProvider(
    val appProvider: ApplicationAnalyticsPropertyProvider,
    val userProps: UserAnalyticsPropertyProvider,
    val deviceProps: DeviceAnalyticsPropertyProvider,
)
