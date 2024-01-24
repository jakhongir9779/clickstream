package analytics.sdk.properties.device.default

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import kotlin.math.pow
import kotlin.math.sqrt

internal actual class DeviceTypeProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = deviceTypePropertyKey

    override fun getValue(): String {
        with((dependencies as AndroidDependencies).context.resources.displayMetrics) {
            val widthInches = widthPixels / xdpi
            val heightInches = heightPixels / ydpi
            val diagonal = sqrt(widthInches.pow(2) + heightInches.pow(2))
            return if (diagonal >= 7) {
                "TABLET"
            } else {
                "MOBILE"
            }
        }
    }
}
