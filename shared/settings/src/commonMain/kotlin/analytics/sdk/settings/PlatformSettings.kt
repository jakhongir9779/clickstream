package analytics.sdk.settings

abstract class PlatformSettings {

    abstract val clickStream: ClickStreamSettings

    abstract val eventProperties: EventPropertiesSettings
}
