package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class OsVersionProperty : DeviceAnalyticsProperties {
    override val key: String = osVersionPropertyKey

    override fun getValue(): String = ""
}
