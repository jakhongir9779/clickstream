package analytics.sdk.clickstream.properties.application.default

import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsProperties

/**
 * Версия приложения в semVer формате
 */
internal class AppVersionProperty(
    private val appVersion: String
) : ApplicationAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        appVersion

    internal companion object {
        const val KEY = "app_version"
    }
}
