package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class OsVersionProperty constructor(): DeviceAnalyticsProperties

internal const val osVersionPropertyKey = "os_version"
