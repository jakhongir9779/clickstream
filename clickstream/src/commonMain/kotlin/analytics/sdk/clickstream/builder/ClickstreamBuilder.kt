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
import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.common.builder.AnalyticsBuilder
import timber.log.Timber

class ClickstreamBuilder : AnalyticsBuilder() {
    private var eventProperties: EventProperties? = null
    private var uiProperties: UiProperties? = null

    private var spaceBuilder: SpaceBuilder? = null
    private var sectionBuilder: SectionBuilder? = null
    private var groupBuilder: GroupBuilder? = null
    private var widgetBuilder: WidgetBuilder? = null

    private var isInteractive = true

    fun event(builder: EventPropertiesBuilder.() -> EventProperties): ClickstreamBuilder {
        this.eventProperties = EventPropertiesBuilder().builder()
        return this
    }

    fun space(build: SpaceBuilder.() -> Space): SpaceBuilder {
        createSpaceBuilderIfNull()
        uiProperties = uiProperties!!.copy(space = spaceBuilder!!.build())
        return spaceBuilder!!
    }

    fun section(build: SectionBuilder.() -> Section): SectionBuilder {
        createSectionBuilderIfNull()
        uiProperties = uiProperties?.copy(section = sectionBuilder!!.build())
        return sectionBuilder!!
    }

    fun group(build: GroupBuilder.() -> Group): GroupBuilder {
        createGroupBuilderIfNull()
        uiProperties = uiProperties?.copy(group = groupBuilder!!.build())
        return groupBuilder!!
    }

    fun widget(build: WidgetBuilder.() -> Widget): WidgetBuilder {
        createWidgetBuilderIfNull()
        uiProperties = uiProperties?.copy(widget = widgetBuilder!!.build())
        return widgetBuilder!!
    }

    fun action(action: UiProperties.Action): ClickstreamBuilder {
        createUiPropertiesIfNull()
        uiProperties = uiProperties!!.copy(action = action)
        return this
    }

    fun interaction(isInteractive: Boolean): ClickstreamBuilder {
        this.isInteractive = isInteractive
        return this
    }

    private fun createWidgetBuilderIfNull() {
        if (widgetBuilder != null) return
        widgetBuilder = WidgetBuilder()
    }

    private fun createUiPropertiesIfNull() {
        if (uiProperties != null) return
        this.uiProperties = UiProperties(
            widget = null, space = null, section = null, group = null, action = null
        )
    }

    private fun createSpaceBuilderIfNull() {
        createUiPropertiesIfNull()
        if (spaceBuilder != null) return
        spaceBuilder = SpaceBuilder()
    }

    private fun createSectionBuilderIfNull() {
        createUiPropertiesIfNull()
        if (sectionBuilder != null) return
        sectionBuilder = SectionBuilder()
    }

    private fun createGroupBuilderIfNull() {
        createUiPropertiesIfNull()
        if (groupBuilder != null) return
        groupBuilder = GroupBuilder()
    }


    /**
     * Validation rules:
     *  - event_props != null, ui_props != null
     *  - event_props != null, ui_props = null
     */
    fun build(): ClickstreamEvent {
        val eventWithUi = eventProperties.isValid() && uiProperties.isValid()
        val eventWithoutUi = eventProperties.isValid() && uiProperties == null

        Timber.e(
            Exception(
                "Should be defined at least event-properties or ui-properties; " +
                        "eventWithUi: $eventWithUi, eventWithoutUi: $eventWithoutUi"
            )
        )

        return ClickstreamEvent(
            eventProperties = eventProperties,
            uiProperties = uiProperties,
            isInteractive = isInteractive,
        )
    }
}

