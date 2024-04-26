package analytics.sdk.properties.application.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.application.ApplicationAnalyticsProperties

/**
 * Идентификатор проекта, в котром установлен кликстрим
 */
internal class PackageNameProperty(
    private val dependencies: PlatformDependencies
) : ApplicationAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String = dependencies.utils.getAppPackage()

    internal companion object {
        const val KEY = "package_name"
    }
}
