package analytics.sdk.properties.user.default

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperties
import android.content.Context
import android.telephony.TelephonyManager
import android.text.TextUtils
import co.touchlab.kermit.Logger

internal actual class OperatorCountryCodeProperty actual constructor(
    private val dependencies: PlatformDependencies
) : UserAnalyticsProperties {
    override val key: String = operatorCountryCodePropertyKey

    private var cache = ""

    override fun getValue(): String {
        try {
            if (cache.isNotEmpty()) return cache
            val networkOperator = ((dependencies as AndroidDependencies).context
                .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager)
                .networkOperator

            if (!TextUtils.isEmpty(networkOperator)) {
                val mcc = networkOperator.substring(0, 3).toInt()
                cache = mcc.toString()
                return cache
            }
        } catch (e: Exception) {
            Logger.e(e) { "Failed to get country code" }
            return ""
        }

        return cache
    }
}
