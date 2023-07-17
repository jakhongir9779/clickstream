package analytics.sdk

import analytics.sdk.event.Event

interface EventSender {
    fun send(addEvents: MutableList<Event>.() -> List<Event>)
}
