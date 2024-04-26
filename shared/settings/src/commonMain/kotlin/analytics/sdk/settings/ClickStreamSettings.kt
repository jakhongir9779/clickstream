package analytics.sdk.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.nullableString

class ClickStreamSettings(settings: Settings) {

    var installId by settings.nullableString(key = INSTALL_ID)

    private companion object {
        const val INSTALL_ID = "install_id"
    }
}
