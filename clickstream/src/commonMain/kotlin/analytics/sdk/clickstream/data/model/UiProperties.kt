package analytics.sdk.clickstream.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal class UiProperties(
    @Json(name = "space")
    val space: Space?,

    @Json(name = "widget")
    val widget: Widget?,

    @Json(name = "section")
    val section: Section?,

    @Json(name = "group")
    val group: Group?,

    @Json(name = "action")
    val action: String?,
)

@JsonClass(generateAdapter = true)
internal class Group(
    @Json(name = "name")
    val name: String,

    @Json(name = "position")
    val position: Long?
)

@JsonClass(generateAdapter = true)
internal class Widget(
    @Json(name = "name")
    val name: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "text")
    val text: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "prompt")
    val prompt: String? = null,

    @Json(name = "position")
    val position: Int? = null,
)

@JsonClass(generateAdapter = true)
internal class Section(
    @Json(name = "id")
    val id: String?,

    @Json(name = "type")
    val type: String?,

    @Json(name = "name")
    val name: String,

    @Json(name = "position")
    val position: Long?,
)

/**
 * WidgetSpace это зона, в пределах которой происходят все взаимодействия с виджетами этой зоны
 */
@JsonClass(generateAdapter = true)
internal class Space(
    // example: 420502
    @Json(name = "id")
    val id: String?,

    // example: PAGE
    @Json(name = "name")
    val name: String,

    // example: 24a4904c-64ff-4cd1-8857-d897116f6c34
    @Json(name = "view_id")
    val viewId: String,

    // example: 522904c-64ff-4cd1-8857-d897116f6c34
    @Json(name = "previous_view_id")
    val previousViewId: String?,

    // example: 1920:1080
    @Json(name = "screen_size")
    val screenSize: String,

    @Json(name = "type")
    val type: String,
)
