package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Язык установленный внутри приложения в ISO 639-1 формате
 */
class LanguageProperty(
    private val language: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        language

    internal companion object {
        const val KEY = "language"
    }
}
