package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal expect class ModelManufacturerProperty constructor() : DeviceAnalyticsProperties

internal const val modelManufacturerPropertyKey = "device_model"
