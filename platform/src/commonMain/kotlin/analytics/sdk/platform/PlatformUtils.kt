package analytics.sdk.platform

import analytics.sdk.platform.model.PlatformConnectionType
import analytics.sdk.platform.properties.EventPropertiesDelegate

interface PlatformUtils {

    fun getTimezone(): String

    fun generateUUID(): String

    fun generateTimestamp(): Long

    fun getConnectionType(): PlatformConnectionType

    fun subscribeOnSessionUpdate(delegate: EventPropertiesDelegate)
}
