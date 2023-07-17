package analytics.sdk.clickstream.properties

interface AnalyticsPropertyProvider {
    val key: String
    fun properties(): Set<AnalyticsPropertyValue>

    //     TODO test // proguard not safe?
    fun toJsonValues(): String {
        return "{${
            properties()
                .filter { it.getValue() != null }
                .joinToString(separator = ",") {
                    "\"${it.key}\":\"${it.getValue()}\""
                }
        }}"
    }
}

// todo account_id отправить стринговый для проверки (сейчас он интовый)
