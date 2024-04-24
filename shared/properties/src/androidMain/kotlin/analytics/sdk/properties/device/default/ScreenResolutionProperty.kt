package analytics.sdk.properties.device.default

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties

internal actual class ScreenResolutionProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = screenResolutionPropertyKey

    override fun getValue(): String {
        return with((dependencies as AndroidDependencies).context.resources.displayMetrics) {
            "$widthPixels:$heightPixels"
        }
    }
}
