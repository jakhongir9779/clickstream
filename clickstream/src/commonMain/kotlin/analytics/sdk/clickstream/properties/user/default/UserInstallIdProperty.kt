package analytics.sdk.clickstream.properties.user.default

import analytics.sdk.clickstream.properties.user.UserAnalyticsProperties
import analytics.sdk.clickstream.settings.ClickStreamSettings

internal class UserInstallIdProperty(
    private val clickStreamSettings: ClickStreamSettings,
    private val getUUID: () -> String,
    private val getExistingInstallId: (() -> String)? = null,
) : UserAnalyticsProperties {
    override val key: String = ClickStreamSettings.INSTALL_ID

    override fun getValue(): String {
        if (getExistingInstallId != null) return getExistingInstallId.invoke()

        return clickStreamSettings.installId ?: run {
            clickStreamSettings.installId = getUUID()
            requireNotNull(value = clickStreamSettings.installId, lazyMessage = { "can't be null" })
        }
    }
}
