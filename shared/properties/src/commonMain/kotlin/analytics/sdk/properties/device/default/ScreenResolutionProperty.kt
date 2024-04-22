package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class ScreenResolutionProperty(
    dependencies: PlatformDependencies
) : DeviceAnalyticsProperties

internal const val screenResolutionPropertyKey = "screen_resolution"
