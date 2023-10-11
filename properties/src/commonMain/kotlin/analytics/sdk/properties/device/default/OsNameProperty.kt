package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class OsNameProperty constructor(): DeviceAnalyticsProperties

internal const val osNamePropertyKey = "os_name"
