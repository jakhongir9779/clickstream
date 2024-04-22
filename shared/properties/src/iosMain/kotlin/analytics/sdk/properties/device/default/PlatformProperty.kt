package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class PlatformProperty : DeviceAnalyticsProperties {
    override val key: String = platformPropertyKey

    override fun getValue(): String = "iOS"
}
