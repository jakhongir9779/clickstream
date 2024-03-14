package analytics.sdk.clickstream.builder

import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.event.Event

// ext for composite analytics
fun MutableList<Event>.clickstream(
    builder: ClickstreamBuilder.() -> ClickstreamEvent
): List<Event> = also { add(ClickstreamBuilder().builder()) }
