package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties

/**
 * Язык установленный внутри приложения в ISO 639-1 формате
 */
class LanguageProperty(
    private val getLanguage: () -> String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        getLanguage()

    internal companion object {
        const val KEY = "language"
    }
}
