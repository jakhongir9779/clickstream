package analytics.sdk.clickstream.builder

import analytics.sdk.clickstream.event.ClickstreamEvent
import analytics.sdk.event.Event

// ext for composite analytics
fun MutableList<Event>.clickstream(
    builder: ClickstreamBuilder.() -> ClickstreamEvent
): List<Event> = also { add(ClickstreamBuilder().builder()) }
