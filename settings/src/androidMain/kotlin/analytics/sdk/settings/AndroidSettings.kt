package analytics.sdk.settings

import android.content.Context
import com.russhwolf.settings.SharedPreferencesSettings

class AndroidSettings(context: Context) : PlatformSettings() {

    override val clickStream: ClickStreamSettings = ClickStreamSettings(
        SharedPreferencesSettings.Factory(context).create("clickstream")
    )

    override val eventProperties: EventPropertiesSettings = EventPropertiesSettings(
        SharedPreferencesSettings.Factory(context).create("event_properties")
    )
}
