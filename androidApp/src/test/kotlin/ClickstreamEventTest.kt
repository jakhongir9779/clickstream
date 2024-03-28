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
        val paramValue = "parameter_value"
        val paramKey2 = "parameter_key2"
        val paramValue2 = "parameter_value2"
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
                parameter(
                    key = paramKey,
                    value = paramValue,
                )
                parameter(
                    key = paramKey2,
                    value = paramValue2,
                )
            }.build()
        }

        clickstreamTest.verifyEventSent(
            event = eventType,
            eventParams = listOf(
                paramKey to paramValue,
                paramKey2 to paramValue2,
            )
        )
    }

}


