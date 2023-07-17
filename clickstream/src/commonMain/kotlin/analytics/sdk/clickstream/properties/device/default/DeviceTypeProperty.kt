package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties

internal class DeviceTypeProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        "MOBILE"

    internal companion object {
        const val KEY = "device_type"
    }
}
