package analytics.sdk.clickstream.builder

import analytics.sdk.clickstream.builder.group.Group
import analytics.sdk.clickstream.builder.group.GroupBuilder
import analytics.sdk.clickstream.builder.properties.EventProperties
import analytics.sdk.clickstream.builder.properties.EventPropertiesBuilder
import analytics.sdk.clickstream.builder.properties.isValid
import analytics.sdk.clickstream.builder.section.Section
import analytics.sdk.clickstream.builder.section.SectionBuilder
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.clickstream.builder.space.SpaceBuilder
import analytics.sdk.clickstream.builder.widget.Widget
import analytics.sdk.clickstream.builder.widget.WidgetBuilder
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.common.builder.AnalyticsBuilder
import co.touchlab.kermit.Logger


class ClickstreamBuilder : AnalyticsBuilder() {
    private var eventProperties: EventProperties? = null
    private var uiProperties = UiProperties()
    private val spaceBuilder: SpaceBuilder by lazy { SpaceBuilder() }
    private val sectionBuilder: SectionBuilder by lazy { SectionBuilder() }
    private val groupBuilder: GroupBuilder by lazy { GroupBuilder() }
    private val widgetBuilder: WidgetBuilder by lazy { WidgetBuilder() }

    private var isInteractive = true

    fun event(builder: EventPropertiesBuilder.() -> EventProperties): ClickstreamBuilder {
        this.eventProperties = EventPropertiesBuilder().builder()
        return this
    }

    fun space(build: SpaceBuilder.() -> Space): SpaceBuilder {
        uiProperties = uiProperties.copy(space = spaceBuilder.build())
        return spaceBuilder
    }

    fun section(build: SectionBuilder.() -> Section): SectionBuilder {
        uiProperties = uiProperties.copy(section = sectionBuilder.build())
        return sectionBuilder
    }

    fun group(build: GroupBuilder.() -> Group): GroupBuilder {
        uiProperties = uiProperties.copy(group = groupBuilder.build())
        return groupBuilder
    }

    fun widget(build: WidgetBuilder.() -> Widget): WidgetBuilder {
        uiProperties = uiProperties.copy(widget = widgetBuilder.build())
        return widgetBuilder
    }

    fun action(action: UiProperties.Action): ClickstreamBuilder {
        uiProperties = uiProperties.copy(action = action)
        return this
    }

    fun interaction(isInteractive: Boolean): ClickstreamBuilder {
        this.isInteractive = isInteractive
        return this
    }

    /**
     * Validation rules:
     *  - event_props != null, ui_props != null
     *  - event_props != null, ui_props = null
     */
    fun build(): ClickstreamEvent {
        val eventWithUiIsValid = eventProperties.isValid() && uiProperties.isValid()
        val eventWithoutUiIsValid = eventProperties.isValid()

        if (!(eventWithUiIsValid || eventWithoutUiIsValid)) {
            Logger.e {
                "Should be defined at least event-properties or ui-properties; " +
                        "eventWithUi: $eventWithUiIsValid, eventWithoutUi: $eventWithoutUiIsValid"
            }
        }

        return ClickstreamEvent(
            eventProperties = eventProperties,
            uiProperties = uiProperties,
            isInteractive = isInteractive,
        )
    }
}

