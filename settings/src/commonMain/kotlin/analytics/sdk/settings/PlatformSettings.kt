package analytics.sdk.settings

abstract class PlatformSettings {

    abstract val clickStreamSettings: ClickStreamSettings

    abstract val eventPropertiesSettings: EventPropertiesSettings
}
