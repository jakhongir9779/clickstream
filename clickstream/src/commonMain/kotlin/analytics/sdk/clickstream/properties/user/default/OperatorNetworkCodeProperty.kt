package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties



/**
 * Мобильный код сети
 */
internal class OperatorNetworkCodeProperty(
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
//                val mnc = Integer.parseInt(networkOperator.substring(3))
//                cache = mnc.toString()
//                return cache
//            }
        } catch (e: Exception) {
//            Timber.e(Exception("Failed to get mobile network code", e))
            return ""
        }

        return cache
    }

    internal companion object {
        const val KEY = "mnc"
    }
}
