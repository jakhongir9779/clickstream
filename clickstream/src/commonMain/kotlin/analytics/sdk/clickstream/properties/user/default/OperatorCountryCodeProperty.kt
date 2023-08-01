package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties



/**
 * Название оператора, используемого клиентом приложения
 */
internal class OperatorCountryCodeProperty(
//    private val context: Context,
) : UserAnalyticsProperties {
    override val key: String = KEY

    var cache = ""

    override fun getValue(): String {
        try {
//            if (cache.isNotEmpty()) return cache
//            val tel = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//            val networkOperator = tel.networkOperator
//
//            if (!TextUtils.isEmpty(networkOperator)) {
//                val mcc = networkOperator.substring(0, 3).toInt()
//                cache = mcc.toString()
//                return cache
//            }
        } catch (e: Exception) {
//            Timber.e(Exception("Failed to get country code", e))
            return ""
        }

        return cache
    }

    internal companion object {
        const val KEY = "mcc"
    }
}
