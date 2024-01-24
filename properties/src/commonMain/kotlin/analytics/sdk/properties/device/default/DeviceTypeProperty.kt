package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class DeviceTypeProperty (
    dependencies: PlatformDependencies
) : DeviceAnalyticsProperties

internal const val deviceTypePropertyKey = "device_type"
