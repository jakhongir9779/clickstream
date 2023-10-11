package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class DeviceTypeProperty constructor() : DeviceAnalyticsProperties

internal const val deviceTypePropertyKey = "device_type"
