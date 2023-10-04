package analytics.sdk.clickstream.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.nullableString

class ClickStreamSettings(settings: Settings) {

    internal var installId by settings.nullableString(key = INSTALL_ID)

    internal companion object {
        const val INSTALL_ID = "install_id"
    }
}
