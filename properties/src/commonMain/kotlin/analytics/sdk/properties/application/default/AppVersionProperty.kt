package analytics.sdk.properties.application.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.application.ApplicationAnalyticsProperties

/**
 * Версия приложения в semVer формате
 */
internal class AppVersionProperty(
    private val dependencies: PlatformDependencies
) : ApplicationAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String = dependencies.appVersion

    internal companion object {
        const val KEY = "app_version"
    }
}
