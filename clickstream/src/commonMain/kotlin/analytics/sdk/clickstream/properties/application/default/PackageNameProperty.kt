package analytics.sdk.clickstream.properties.application.default

import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsProperties

/**
 * Идентификатор проекта, в котром установлен кликстрим
 */
internal class PackageNameProperty(
    private val packageName: String
) : ApplicationAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        packageName

    internal companion object {
        const val KEY = "package_name"
    }
}
