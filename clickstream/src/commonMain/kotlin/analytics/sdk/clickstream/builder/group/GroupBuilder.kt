package analytics.sdk.clickstream.builder.group

import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
class GroupBuilder internal constructor() : ClickstreamGroupMarker() {
    private var group: Group = Group("", 0)

    fun name(name: String): Group {
        group = group.copy(name = name)
        return group
    }

    fun position(@ObjCName(swiftName = "int32") position: Int): Group {
        group = group.copy(position = position.toLong())
        return group
    }

    fun position(@ObjCName(swiftName = "int") position: Long): Group {
        group = group.copy(position = position)
        return group
    }

}
