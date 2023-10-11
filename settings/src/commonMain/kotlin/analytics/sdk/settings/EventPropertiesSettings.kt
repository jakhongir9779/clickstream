package analytics.sdk.settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.nullableString

class EventPropertiesSettings(settings: Settings) {

    var sessionId by settings.nullableString(key = SESSION_ID)
    var lastViewId by settings.nullableString(key = LAST_VIEW_ID)

    private companion object {
        const val SESSION_ID = "session_id"
        const val LAST_VIEW_ID = "last_view_id"
    }
}
