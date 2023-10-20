package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import platform.AdSupport.ASIdentifierManager

internal actual class AdvertisingIdProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = "idfa"

    override fun getValue(): String =
        ASIdentifierManager.sharedManager().advertisingIdentifier.UUIDString
}
