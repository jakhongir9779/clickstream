@file:OptIn(ExperimentalObjCName::class)

package analytics.sdk.clickstream.builder.space

import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@Serializable
data class Space internal constructor(
    val id: String?,
    val name: String,
    val type: Type,
    val screenSize: String,
) {
    @ObjCName(swiftName = "Types")
    enum class Type {
        PAGE,
        MODAL,
    }
}
