package analytics.sdk.properties.device.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.device.DeviceAnalyticsProperties
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen

internal actual class ScreenResolutionProperty actual constructor(
    private val dependencies: PlatformDependencies
) : DeviceAnalyticsProperties {
    override val key: String = screenResolutionPropertyKey

    @OptIn(ExperimentalForeignApi::class)
    override fun getValue(): String = with(UIScreen.mainScreen) {
        val width = (scale * bounds.useContents { size.width }).toInt()
        val height = (scale * bounds.useContents { size.height }).toInt()
        "$width:$height"
    }
}
