package analytics.sdk.clickstream.builder.widget

class WidgetBuilder internal constructor() : ClickstreamWidgetBuilder() {
    private var widget: Widget? = null

    fun button(name: String, text: String): Widget.Button =
        Widget.Button(
            name = name,
            text = text
        ).also { widget = it }

    fun image(name: String, text: String, url: String): Widget.Image =
        Widget.Image(
            name = name,
            text = text,
            url = url
        ).also { widget = it }

    fun input(name: String, text: String, prompt: String?): Widget.Input =
        Widget.Input(
            name = name,
            text = text,
            prompt = prompt,
        ).also { widget = it }

    fun select(name: String, text: String, position: Int?): Widget.Select =
        Widget.Select(
            name = name,
            text = text,
            position = position,
        ).also { widget = it }

    fun text(name: String, text: String): Widget.Text =
        Widget.Text(
            name = name,
            text = text,
        ).also { widget = it }
}
