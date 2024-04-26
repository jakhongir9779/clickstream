package analytics.sdk.properties.application.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.application.ApplicationAnalyticsProperties

/**
 * Версия приложения в semVer формате
 */
internal interface AppVersionProperties : ApplicationAnalyticsProperties {

    companion object {
        const val KEY = "app_version"
    }
}

internal class DefaultAppVersionProperty(
    private val dependencies: PlatformDependencies
) : AppVersionProperties {
    override val key: String = AppVersionProperties.KEY

    override fun getValue(): String = dependencies.utils.getAppVersion()
}

class AppVersionProperty(
    private val version: String
) : AppVersionProperties {
    override val key: String = AppVersionProperties.KEY

    override fun getValue(): String =
        version
}
