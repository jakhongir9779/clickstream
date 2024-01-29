package analytics.sdk.properties.user.default

import analytics.sdk.properties.user.UserAnalyticsProperties

/**
 * Уникальный числовой идентификатор пользователя в системе
 */
class AccountIdProperty(
    private val accountId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        accountId

    internal companion object {
        const val KEY = "account_id"
    }
}
