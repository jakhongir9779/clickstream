package analytics.sdk.clickstream.builder.group

class GroupBuilder internal constructor() : ClickstreamGroupMarker() {
    private var group: Group = Group("", 0)

    fun name(name: String): Group {
        group = group.copy(name = name)
        return group
    }

    fun position(position: Int): Group {
        group = group.copy(position = position.toLong())
        return group
    }

    fun position(position: Long): Group {
        group = group.copy(position = position)
        return group
    }

}
