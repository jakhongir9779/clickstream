package analytics.sdk.clickstream.builder

import analytics.sdk.clickstream.builder.group.Group
import analytics.sdk.clickstream.builder.section.Section
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.clickstream.builder.widget.Widget
import kotlinx.serialization.Serializable

@Serializable
data class UiProperties internal constructor(
    val widget: Widget? = null,
    val space: Space? = null,
    val section: Section? = null,
    val group: Group? = null,
    val action: Action? = null,
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
