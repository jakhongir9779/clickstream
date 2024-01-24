package analytics.sdk.clickstream.mappers

import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.group.Group
import analytics.sdk.clickstream.builder.section.Section
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.clickstream.builder.widget.Widget

internal fun UiProperties.toDb(
    viewId: String,
    previousViewId: String?,
    screenResolution: String,
): analytics.sdk.clickstream.data.model.UiProperties {
    val widget = widget?.toDb()
    val space = space?.toDb(viewId, previousViewId, screenResolution)
    val section = section?.toDb()
    val action = action?.toDb()
    val group = group?.toDb()

    return analytics.sdk.clickstream.data.model.UiProperties(
        space = space,
        widget = widget,
        section = section,
        group = group,
        action = action,
    )
}

private fun Space.toDb(
    viewId: String,
    previousViewId: String?,
    screenResolution: String,
): analytics.sdk.clickstream.data.model.Space =
    analytics.sdk.clickstream.data.model.Space(
        id = id,
        name = name,
        viewId = viewId,
        previousViewId = previousViewId,
        type = type.toDb(),
        screenSize = screenSize.ifEmpty { screenResolution },
    )

private fun Space.Type.toDb(): String =
    when (this) {
        Space.Type.MODAL -> "MODAL"
        Space.Type.PAGE -> "PAGE"
    }

private fun Section.toDb(): analytics.sdk.clickstream.data.model.Section =
    analytics.sdk.clickstream.data.model.Section(
        id = id,
        type = type,
        name = name,
        position = position,
    )

private fun Group.toDb(): analytics.sdk.clickstream.data.model.Group =
    analytics.sdk.clickstream.data.model.Group(
        name = name,
        position = position
    )

private fun Widget.toDb(): analytics.sdk.clickstream.data.model.Widget =
    when (this) {
        is Widget.Button -> toDb()
        is Widget.Image -> toDb()
        is Widget.Input -> toDb()
        is Widget.Select -> toDb()
        is Widget.Text -> toDb()
    }

private fun Widget.Button.toDb() = analytics.sdk.clickstream.data.model.Widget(
    name = name,
    type = type.toDb(),
    text = text,
    position = position,
)

private fun Widget.Image.toDb() = analytics.sdk.clickstream.data.model.Widget(
    name = name,
    type = type.toDb(),
    url = url,
    position = position,
)

private fun Widget.Input.toDb() = analytics.sdk.clickstream.data.model.Widget(
    name = name,
    type = type.toDb(),
    text = text,
    prompt = prompt,
    position = position,
)

private fun Widget.Select.toDb() = analytics.sdk.clickstream.data.model.Widget(
    name = name,
    type = type.toDb(),
    text = text,
    position = position,
)

private fun Widget.Text.toDb() = analytics.sdk.clickstream.data.model.Widget(
    name = name,
    type = type.toDb(),
    text = text,
    position = position,
)

private fun Widget.Type.toDb(): String =
    when (this) {
        Widget.Type.BUTTON -> "BUTTON"
        Widget.Type.IMAGE -> "IMAGE"
        Widget.Type.VIDEO -> "VIDEO"
        Widget.Type.INPUT -> "INPUT"
        Widget.Type.SELECT -> "SELECT"
        Widget.Type.TEXT -> "TEXT"
    }

private fun UiProperties.Action?.toDb(): String =
    when (this) {
        UiProperties.Action.SHOW -> "SHOW"
        UiProperties.Action.CLICK -> "CLICK"
        UiProperties.Action.SWIPE -> "SWIPE"
        UiProperties.Action.INPUT -> "INPUT"
        UiProperties.Action.AUTO_INPUT -> "AUTO_INPUT"
        UiProperties.Action.SUBMIT -> "SUBMIT"
        UiProperties.Action.SLIDE -> "SLIDE"
        UiProperties.Action.DRAG -> "DRAG"
        UiProperties.Action.SCROLL -> "SCROLL"
        UiProperties.Action.SPACE_OPEN -> "SPACE_OPEN"
        else -> ""
    }
