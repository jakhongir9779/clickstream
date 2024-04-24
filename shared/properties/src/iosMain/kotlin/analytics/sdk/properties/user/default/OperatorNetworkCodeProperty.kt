package analytics.sdk.properties.user.default

import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.user.UserAnalyticsProperty
import platform.CoreTelephony.CTTelephonyNetworkInfo

internal actual class OperatorNetworkCodeProperty actual constructor(
    private val dependencies: PlatformDependencies
) : UserAnalyticsProperty {
    override val key: String = operatorNetworkCodePropertyKey

    override fun getValue(): String? =
        CTTelephonyNetworkInfo().subscriberCellularProvider?.mobileNetworkCode
}
