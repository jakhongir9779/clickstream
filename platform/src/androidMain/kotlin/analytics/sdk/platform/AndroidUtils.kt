package analytics.sdk.platform

import analytics.sdk.platform.model.PlatformConnectionType
import analytics.sdk.platform.properties.ClickstreamLifecycleCallbacks
import analytics.sdk.platform.properties.EventPropertiesDelegate
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import java.util.TimeZone
import java.util.UUID

class AndroidUtils(private val context: Context) : PlatformUtils {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun getTimezone(): String = TimeZone.getDefault().id

    override fun generateUUID(): String = UUID.randomUUID().toString()

    override fun generateTimestamp(): Long = System.currentTimeMillis()

    override fun getConnectionType(): PlatformConnectionType =
        with(connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)) {
            when {
                this?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true -> PlatformConnectionType.WIFI
                this?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true -> PlatformConnectionType.CELLULAR
                else -> PlatformConnectionType.UNKNOWN
            }
        }

    override fun subscribeOnSessionUpdate(delegate: EventPropertiesDelegate) {
        check(context is Application)
        context.registerActivityLifecycleCallbacks(
            ClickstreamLifecycleCallbacks(context, delegate)
        )
    }
}
