package analytics.sdk.settings

import android.content.Context
import com.russhwolf.settings.SharedPreferencesSettings

class AndroidSettings(context: Context): PlatformSettings() {

    override val clickStreamSettings: ClickStreamSettings = ClickStreamSettings(
        SharedPreferencesSettings(
            context.getSharedPreferences("clickstream", Context.MODE_PRIVATE)
        )
    )

    override val eventPropertiesSettings: EventPropertiesSettings = EventPropertiesSettings(
        SharedPreferencesSettings(
            context.getSharedPreferences("event_properties", Context.MODE_PRIVATE)
        )
    )
}
