package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties
import android.content.Context
import android.telephony.TelephonyManager
import timber.log.Timber


/**
 * Название оператора, используемого клиентом приложения
 */
internal class OperatorNameProperty(
    private val context: Context,
) : UserAnalyticsProperties {
    override val key: String = KEY

    var cache = ""

    override fun getValue(): String {
        try {
            if (cache.isNotEmpty()) return cache
            cache =
                (context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager)
                    .networkOperatorName
        } catch (e: Exception) {
            Timber.e(Exception("Failed to get operator name", e))
            return ""
        }

        return cache
    }

    internal companion object {
        const val KEY = "operator_name"
    }
}
