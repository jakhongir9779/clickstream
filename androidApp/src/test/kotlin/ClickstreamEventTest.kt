import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.test.ClickstreamTestRule
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ClickstreamEventTest {

    @get:Rule
    val clickstreamTest = ClickstreamTestRule()

    @Test
    fun clickStreamEventSent() = runTest {
        val paramKey = "parameter_key"
        val paramStringValue = "parameter_value"
        val paramKey2 = "parameter_key2"
        val paramIntValue = 100
        val paramKey3 = "parameter_key3"
        val paramLongValue = 103L
        val paramKey4 = "parameter_key4"
        val paramDoubleValue = 101.00
        val paramKey5 = "parameter_key5"
        val paramBooleanValue = true
        val paramKey6 = "parameter_key6"
        val paramListNumbers = listOf(1L, 2f, 4.0)
        val paramKey7 = "parameter_key7"
        val paramListStrings = listOf("one", "two", "three")
        val eventType = "EVENT_TYPE"

        clickstreamTest.send {
            space {
                id(1)
                name("space_name")
                type(Space.Type.PAGE)
                screenSize("1920:1080")
            }
            section {
                id(2)
                type("section_type")
                name("section_name")
                position(1)
            }
            group {
                name("group_name")
                position(2)
            }
            widget {
                input(
                    name = "input_name",
                    text = "input_text",
                    prompt = "input_prompt",
                    position = 3,
                )
            }
            action(UiProperties.Action.SHOW)
            interaction(true)
            event {
                type(eventType)
                parameter(key = paramKey, value = paramStringValue)
                parameter(key = paramKey2, value = paramIntValue)
                parameter(key = paramKey3, value = paramLongValue)
                parameter(key = paramKey4, value = paramDoubleValue)
                parameter(key = paramKey5, value = paramBooleanValue)
                stringListParameter(key = paramKey6, value = paramListStrings)
                numberListParameter(key = paramKey7, value = paramListNumbers)
            }.build()
        }

        clickstreamTest.verifyEventSent(
            event = eventType, eventParams = mapOf(
                paramKey to paramStringValue,
                paramKey2 to paramIntValue,
                paramKey3 to paramLongValue,
                paramKey4 to paramDoubleValue,
                paramKey5 to paramBooleanValue,
                paramKey6 to paramListStrings,
                paramKey7 to paramListNumbers,
            )
        )
    }

}
