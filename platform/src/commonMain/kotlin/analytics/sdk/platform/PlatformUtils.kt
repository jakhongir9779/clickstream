package analytics.sdk.platform

import analytics.sdk.platform.properties.EventPropertiesDelegate

interface PlatformUtils {

    val getExistingInstallId: (() -> String)?

    fun getTimezone(): String

    fun generateUUID(): String

    fun generateTimestamp(): Long

    fun isWifiConnection(): Boolean

    fun registerScreenCallbacks(delegate: EventPropertiesDelegate)
}
