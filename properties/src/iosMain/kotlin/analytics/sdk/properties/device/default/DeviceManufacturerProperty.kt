package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class DeviceManufacturerProperty : DeviceAnalyticsProperties {
    override val key: String = deviceManufacturerPropertyKey

    override fun getValue(): String = "Apple"
}
