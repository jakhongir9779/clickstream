package analytics.sdk.properties

import analytics.sdk.properties.application.ApplicationAnalyticsPropertyProvider
import analytics.sdk.properties.device.DeviceAnalyticsPropertyProvider
import analytics.sdk.properties.user.UserAnalyticsPropertyProvider
import kotlinx.serialization.Serializable

@Serializable
class PropertiesProvider(
    val appProvider: ApplicationAnalyticsPropertyProvider,
    val userProps: UserAnalyticsPropertyProvider,
    val deviceProps: DeviceAnalyticsPropertyProvider,
)
