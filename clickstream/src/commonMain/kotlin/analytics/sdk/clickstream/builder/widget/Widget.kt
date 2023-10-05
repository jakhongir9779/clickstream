package analytics.sdk.clickstream.builder.widget

import kotlinx.serialization.Serializable

@Serializable
sealed class Widget private constructor(
    open val name: String,
    val type: Type,
) {

    class Button internal constructor(
        override val name: String,
        val text: String
    ) : Widget(name, Type.BUTTON)

    class Image internal constructor(
        override val name: String,
        val text: String,
        val url: String,
    ) : Widget(name, Type.IMAGE)

    class Input internal constructor(
        override val name: String,
        val text: String,
        val prompt: String?,
    ) : Widget(name, Type.INPUT)

    class Select internal constructor(
        override val name: String,
        val text: String,
        val position: Int?,
    ) : Widget(name, Type.SELECT)

    class Text internal constructor(
        override val name: String,
        val text: String,
    ) : Widget(name, Type.TEXT)

    enum class Type {
        BUTTON,
        IMAGE,
        VIDEO,
        INPUT,
        SELECT,
        TEXT,
    }
}
