package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class PlatformProperty constructor() : DeviceAnalyticsProperties

internal const val platformPropertyKey = "platform"
