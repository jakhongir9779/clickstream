package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperty

/**
 * Уникальный числовой идентификатор пользователя в системе
 */
class AccountIdProperty(private val get: () -> String) : UserAnalyticsProperty {
    override val key: String = KEY

    override fun getValue(): String = get()

    internal companion object {
        const val KEY = "account_id"
    }
}
