package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Язык установленный внутри приложения в ISO 639-1 формате
 */
class LanguageProperty(private val get: () -> String) : UserAnalyticsProperty {
    override val key: String = KEY

    override fun getValue(): String = get()

    internal companion object {
        const val KEY = "language"
    }
}
