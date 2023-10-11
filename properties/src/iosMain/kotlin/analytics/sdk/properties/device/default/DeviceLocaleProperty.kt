package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class DeviceLocaleProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = DEVICE_LOCALE_PROPERTY_KEY

    override fun getValue(): String = dependencies.toString()
}
