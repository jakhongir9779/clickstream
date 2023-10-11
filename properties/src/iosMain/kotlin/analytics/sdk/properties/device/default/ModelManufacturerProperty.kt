package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class ModelManufacturerProperty : DeviceAnalyticsProperties {
    override val key: String = modelManufacturerPropertyKey

    override fun getValue(): String = ""
}
