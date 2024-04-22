package analytics.sdk.platform

import analytics.sdk.platform.model.PlatformConnectionType
import analytics.sdk.platform.properties.EventPropertiesDelegate

interface PlatformUtils {

    fun initAllowed(): Boolean

    fun getAppPackage() : String

    fun getAppVersion() : String

    fun getTimezone(): String

    fun generateUUID(): String

    fun generateTimestamp(): Long

    fun getConnectionType(): PlatformConnectionType

    fun subscribeOnSessionUpdate(delegate: EventPropertiesDelegate)
}
