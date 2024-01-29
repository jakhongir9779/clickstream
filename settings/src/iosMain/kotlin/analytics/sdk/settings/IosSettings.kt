package analytics.sdk.settings

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.NSUserDefaultsSettings

class IosSettings : PlatformSettings() {

    @OptIn(ExperimentalSettingsImplementation::class)
    override val clickStream: ClickStreamSettings = ClickStreamSettings(
        KeychainSettings.Factory().create("clickstream")
    )

    override val eventProperties: EventPropertiesSettings = EventPropertiesSettings(
        NSUserDefaultsSettings.Factory().create("event_properties")
    )
}
