package analytics.sdk.clickstream.event

import analytics.sdk.AnalyticsType
import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.properties.EventProperties
import analytics.sdk.clickstream.type.Clickstream
import analytics.sdk.event.Event
import org.jetbrains.annotations.VisibleForTesting

data class ClickstreamEvent internal constructor(
    @VisibleForTesting val eventProperties: EventProperties? = null,
    @VisibleForTesting val uiProperties: UiProperties?,
    @VisibleForTesting val isInteractive: Boolean = true,
) : Event {
    override val analyticsType: AnalyticsType = Clickstream
}
