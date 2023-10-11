package analytics.sdk.platform

import analytics.sdk.platform.properties.ClickstreamLifecycleCallbacks
import analytics.sdk.platform.properties.EventPropertiesDelegate
import android.app.Application
import android.content.Context
import android.icu.util.Calendar
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import java.util.UUID

class AndroidUtils(private val context: Context) : PlatformUtils {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override val getExistingInstallId: (() -> String)? = null

    override fun generateUUID(): String = UUID.randomUUID().toString()

    override fun getTimezone(): String = Calendar.getInstance().timeZone.id

    override fun generateTimestamp(): Long = System.currentTimeMillis()

    override fun isWifiConnection(): Boolean =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            ?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true

    override fun registerScreenCallbacks(delegate: EventPropertiesDelegate) {
        check(context is Application)
        context.registerActivityLifecycleCallbacks(
            ClickstreamLifecycleCallbacks(context, delegate, delegate)
        )
    }
}
