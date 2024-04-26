package analytics.sdk.clickstream.builder.section

import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
class SectionBuilder internal constructor() : ClickstreamSectionMarker() {
    private var section: Section = Section(
        id = null,
        position = null,
        name = "",
        type = null
    )

    fun id(@ObjCName(swiftName = "string") id: String): Section {
        section = section.copy(id = id)
        return section
    }

    fun id(@ObjCName(swiftName = "int32") id: Int): Section {
        section = section.copy(id = id.toString())
        return section
    }

    fun id(@ObjCName(swiftName = "int") id: Long): Section {
        section = section.copy(id = id.toString())
        return section
    }

    fun name(name: String): Section {
        section = section.copy(name = name)
        return section
    }

    fun type(type: String?): Section {
        section = section.copy(type = type)
        return section
    }

    fun position(@ObjCName(swiftName = "int32") position: Int): Section {
        section = section.copy(position = position.toLong())
        return section
    }

    fun position(@ObjCName(swiftName = "int") position: Long): Section {
        section = section.copy(position = position)
        return section
    }
}
