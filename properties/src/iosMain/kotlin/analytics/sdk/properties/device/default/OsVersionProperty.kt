package analytics.sdk.properties.device.default

import analytics.sdk.properties.device.DeviceAnalyticsProperties
import platform.UIKit.UIDevice

internal actual class OsVersionProperty : DeviceAnalyticsProperties {
    override val key: String = osVersionPropertyKey

    override fun getValue(): String = UIDevice.currentDevice.systemVersion
}
