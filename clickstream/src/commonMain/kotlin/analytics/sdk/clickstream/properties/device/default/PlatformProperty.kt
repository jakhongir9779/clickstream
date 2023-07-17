package analytics.sdk.clickstream.properties.device.default

import analytics.sdk.clickstream.properties.device.DeviceAnalyticsProperties

internal class PlatformProperty : DeviceAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        "Android"

    internal companion object {
        const val KEY = "platform"
    }
}
