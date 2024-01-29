package analytics.sdk.clickstream.event

import analytics.sdk.AnalyticsType
import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.properties.EventProperties
import analytics.sdk.clickstream.type.Clickstream
import analytics.sdk.event.Event
import kotlinx.serialization.Serializable

@Serializable
data class ClickstreamEvent internal constructor(
     val eventProperties: EventProperties? = null,
     val uiProperties: UiProperties?,
     val isInteractive: Boolean,
) : Event {
    override val analyticsType: AnalyticsType = Clickstream
}
