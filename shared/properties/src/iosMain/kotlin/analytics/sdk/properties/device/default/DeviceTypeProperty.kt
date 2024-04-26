package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import platform.UIKit.UIDevice
import platform.UIKit.UIUserInterfaceIdiomMac
import platform.UIKit.UIUserInterfaceIdiomPad

internal actual class DeviceTypeProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = deviceTypePropertyKey

    override fun getValue(): String {
        return when (UIDevice.currentDevice.userInterfaceIdiom) {
            UIUserInterfaceIdiomPad -> "TABLET"
            UIUserInterfaceIdiomMac -> "DESKTOP"
            else -> "MOBILE"
        }
    }
}
