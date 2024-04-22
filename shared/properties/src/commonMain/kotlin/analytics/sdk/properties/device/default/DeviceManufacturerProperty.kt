package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class DeviceManufacturerProperty constructor() : DeviceAnalyticsProperties

internal const val deviceManufacturerPropertyKey = "device_manufacturer"
