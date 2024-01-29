package analytics.sdk.clickstream.builder.space

import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName


@OptIn(ExperimentalObjCName::class)
class SpaceBuilder internal constructor() : ClickstreamSpaceMarker() {
    private var space: Space = Space(
        id = null,
        name = "",
        type = Space.Type.PAGE,
        screenSize = "",
    )

    fun id(@ObjCName(swiftName = "string") id: String): Space {
        space = space.copy(id = id)
        return space
    }

    fun id(@ObjCName(swiftName = "int32") id: Int): Space {
        space = space.copy(id = id.toString())
        return space
    }

    fun id(@ObjCName(swiftName = "int") id: Long): Space {
        space = space.copy(id = id.toString())
        return space
    }

    fun name(name: String): Space {
        space = space.copy(name = name)
        return space
    }

    fun type(type: Space.Type): Space {
        space = space.copy(type = type)
        return space
    }

    fun screenSize(screenSize: String): Space {
        space = space.copy(screenSize = screenSize)
        return space
    }
}
