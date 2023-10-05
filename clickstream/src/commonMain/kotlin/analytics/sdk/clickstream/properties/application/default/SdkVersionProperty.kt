package analytics.sdk.clickstream.properties.application.default

import analytics.sdk.clickstream.properties.application.ApplicationAnalyticsProperties

/**
 * Версия установленного SDK
 */
internal class SdkVersionProperty : ApplicationAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =""
//        BuildConfig.SDK_VERSION

    internal companion object {
        const val KEY = "sdk_version"
    }
}
