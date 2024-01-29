package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties
import platform.UIKit.UIDevice

internal actual class VendorIdProperty : DeviceAnalyticsProperties {
    override val key: String = "idfv"

    override fun getValue(): String? = UIDevice.currentDevice.identifierForVendor?.UUIDString
}
