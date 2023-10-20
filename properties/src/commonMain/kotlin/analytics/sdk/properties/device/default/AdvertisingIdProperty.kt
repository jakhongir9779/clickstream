package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class AdvertisingIdProperty(
    dependencies: PlatformDependencies
) : DeviceAnalyticsProperties
