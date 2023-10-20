package analytics.sdk.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.nullableString

class EventPropertiesSettings(settings: Settings) {

    var lastViewId by settings.nullableString(key = LAST_VIEW_ID)

    private companion object {
        const val LAST_VIEW_ID = "last_view_id"
    }
}
