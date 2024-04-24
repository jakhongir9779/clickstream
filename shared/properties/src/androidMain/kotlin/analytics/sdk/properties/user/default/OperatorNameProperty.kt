package analytics.sdk.properties.user.default

import analytics.sdk.platform.AndroidDependencies
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperty
import android.content.Context
import android.telephony.TelephonyManager
import co.touchlab.kermit.Logger

internal actual class OperatorNameProperty actual constructor(
    private val dependencies: PlatformDependencies
) : UserAnalyticsProperty {
    override val key: String = operatorNamePropertyKey

    private var cache = ""

    override fun getValue(): String {
        try {
            if (cache.isNotEmpty()) return cache
            cache = ((dependencies as AndroidDependencies)
                .context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager)
                .networkOperatorName
        } catch (e: Exception) {
            Logger.e(e) { "Failed to get operator name" }
            return ""
        }
        return cache
    }
}
