import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.test.ClickstreamTestRule
import io.mockk.coEvery
import io.mockk.coVerify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ClickstreamEventTest {

    @get:Rule
    val clickstreamTest = ClickstreamTestRule()

    @Test
    fun clickStreamEventSent() = runTest {
        lateinit var someEvent: ClickstreamEvent
        var resultEvent: Any? = null
        coEvery { clickstreamTest.eventSender.send(any()) } answers { resultEvent = valueAny }
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
            someEvent = event {
                type("event_type")
                parameter(
                    key = "parameter_key",
                    value = "parameter_value"
                )
            }.build()
            someEvent
        }
        coVerify { clickstreamTest.eventSender.send(any()) }
        assertEquals(someEvent, resultEvent)
        assert(resultEvent is ClickstreamEvent)
        assertEquals(someEvent.uiProperties, (resultEvent as ClickstreamEvent).uiProperties)
        assertEquals(someEvent.eventProperties, (resultEvent as ClickstreamEvent).eventProperties)
    }

}
