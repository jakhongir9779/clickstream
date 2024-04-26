package analytics.sdk.clickstream.builder.widget

class WidgetBuilder internal constructor() : ClickstreamWidgetBuilder() {
    private var widget: Widget? = null

    fun button(name: String, text: String, position: Int? = null): Widget.Button =
        Widget.Button(
            name = name,
            text = text,
            position = position,
        ).also { widget = it }

    fun image(name: String, url: String, position: Int? = null): Widget.Image =
        Widget.Image(
            name = name,
            url = url,
            position = position,
        ).also { widget = it }

    fun input(name: String, text: String, prompt: String?, position: Int? = null): Widget.Input =
        Widget.Input(
            name = name,
            text = text,
            prompt = prompt,
            position = position,
        ).also { widget = it }

    fun select(name: String, text: String, position: Int? = null): Widget.Select =
        Widget.Select(
            name = name,
            text = text,
            position = position,
        ).also { widget = it }

    fun text(name: String, text: String, position: Int? = null): Widget.Text =
        Widget.Text(
            name = name,
            text = text,
            position = position,
        ).also { widget = it }
}
