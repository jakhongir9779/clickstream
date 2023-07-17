package analytics.sdk.clickstream.builder

import analytics.sdk.clickstream.builder.group.Group
import analytics.sdk.clickstream.builder.section.Section
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.clickstream.builder.widget.Widget

data class UiProperties internal constructor(
    val widget: Widget?,
    val space: Space?,
    val section: Section?,
    val group: Group?,
    val action: Action?
) {
    enum class Action {
        SHOW,
        CLICK,
        SWIPE,
        INPUT,
        AUTO_INPUT,
        SUBMIT,
        SLIDE,
        DRAG,
        SCROLL,
        SPACE_OPEN,
    }
}

internal fun UiProperties?.isValid(): Boolean {
    if (this == null) return false
    return (widget != null || space != null || section != null || group != null) && action != null
}
