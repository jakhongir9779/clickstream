package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class GoogleAdvertisingIdProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = googleAdvertisingIdPropertyKey

    override fun getValue(): String = dependencies.toString()
}
