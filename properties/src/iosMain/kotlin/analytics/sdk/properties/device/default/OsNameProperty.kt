package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class OsNameProperty : DeviceAnalyticsProperties {
    override val key: String = osNamePropertyKey

    override fun getValue(): String = ""
}
