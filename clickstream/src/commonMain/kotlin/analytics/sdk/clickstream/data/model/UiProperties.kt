package analytics.sdk.clickstream.data.model



internal class UiProperties(
    val space: Space?,

    val widget: Widget?,

    val section: Section?,

    val group: Group?,

    val action: String?,
)


internal class Group(
    val name: String,

    val position: Long?
)


internal class Widget(
    val name: String,

    val type: String,

    val text: String? = null,

    val url: String? = null,

    val prompt: String? = null,

    val position: Int? = null,
)


internal class Section(
    val id: String?,

    val type: String?,

    val name: String,

    val position: Long?,
)

/**
 * WidgetSpace это зона, в пределах которой происходят все взаимодействия с виджетами этой зоны
 */

internal class Space(
    // example: 420502
    val id: String?,

    // example: PAGE
    val name: String,

    // example: 24a4904c-64ff-4cd1-8857-d897116f6c34
    val viewId: String,

    // example: 522904c-64ff-4cd1-8857-d897116f6c34
    val previousViewId: String?,

    // example: 1920:1080
    val screenSize: String,

    val type: String,
)
