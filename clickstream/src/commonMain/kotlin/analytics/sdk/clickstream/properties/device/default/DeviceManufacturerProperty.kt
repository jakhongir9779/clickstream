package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties

internal class DeviceManufacturerProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =   "" /*    Build.MANUFACTURER*/

    internal companion object {
        const val KEY = "device_manufacturer"
    }
}
