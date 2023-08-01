package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties
//import analytics.sdk.clickstream.sharedpreference.key
//import android.content.SharedPreferences

internal class UserInstallIdProperty(
//    sharedPreferences: SharedPreferences,
    private val getUUID: () -> String,
    private val getExistingInstallId: (() -> String)? = null
) : UserAnalyticsProperties {
    override val key: String = INSTALL_ID

//    private var installId: String? by sharedPreferences key INSTALL_ID

    override fun getValue(): String {
//        if (getExistingInstallId != null) return getExistingInstallId.invoke()
//
//        if (installId != null) return installId ?: error("can't be null")
//        installId = getUUID()
//
//        return installId ?: error("can't be null")
        return ""
    }

    internal companion object {
        const val INSTALL_ID = "install_id"
    }
}
