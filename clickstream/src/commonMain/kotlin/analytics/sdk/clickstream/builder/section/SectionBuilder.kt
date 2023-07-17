package analytics.sdk.clickstream.builder.section

class SectionBuilder internal constructor() : ClickstreamSectionMarker() {
    private var section: Section = Section(
        id = null,
        position = null,
        name = "",
        type = null
    )

    fun id(id: String): Section {
        section = section.copy(id = id)
        return section
    }

    fun id(id: Int): Section {
        section = section.copy(id = id.toString())
        return section
    }

    fun id(id: Long): Section {
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
}
