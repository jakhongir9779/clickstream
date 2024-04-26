package analytics.sdk.properties.application.default

import analytics.sdk.properties.application.ApplicationAnalyticsProperties

/**
 * Версия установленного SDK
 */
internal class SdkVersionProperty : ApplicationAnalyticsProperties {
    override val key: String = KEY

    // TODO: Do not hardcode version
    override fun getValue(): String = "1.0"

    internal companion object {
        const val KEY = "sdk_version"
    }
}
