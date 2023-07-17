package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties

/**
 * Аннонимный идентификатор клиента Яндекс Метрики
 */
class YandexMetricaIdProperty(
    private val yandexMetricaId: String
) : UserAnalyticsProperties {
    override val key: String = KEY

    override fun getValue(): String =
        yandexMetricaId

    internal companion object {
        const val KEY = "ya_metrica_id"
    }
}
