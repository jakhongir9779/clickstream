package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class VendorIdProperty : DeviceAnalyticsProperties {
    override val key: String = "" // Required for iOS only

    override fun getValue(): String? = null
}
