package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class DeviceTypeProperty : DeviceAnalyticsProperties {
    override val key: String = deviceTypePropertyKey

    override fun getValue(): String = "MOBILE"
}
