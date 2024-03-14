import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.ClickstreamSdkImpl
import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.space.Space
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.platform.PlatformDependencies
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ClickStreamEventTest {


    @Before
    fun before() {

    }

    @Test
    fun clickStreamEventSent() = runTest {
        lateinit var someEvent: ClickstreamEvent
        val mock = spyk(ClickstreamSdkImpl, recordPrivateCalls = true)
        val dependencies = mockk<PlatformDependencies>(relaxed = true)
        val scheduler = mockk<AnalyticsJobScheduler>(relaxed = true)
        every { dependencies.utils } returns mockk(relaxed = true)
        every { dependencies.utils.initAllowed() } returns true
        val config = ClickstreamConfig()
        mock.getInstance().initialize(
            url = "",
            dependencies = dependencies,
            analyticsJobScheduler = scheduler,
            propertiesProvider = null,
            config = config,
            requestHeaders = mapOf()
        )
        val sender = mockk<AnalyticsEventSender>()
        val senderField = ClickstreamSdkImpl::class.java.getDeclaredField("sender")
        senderField.isAccessible = true
        senderField.set(mock.getInstance(), sender)

        var resultEvent: Any? = null
        coEvery { sender.send(any()) } answers { resultEvent = valueAny }
        mock.getInstance().send {
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
        coVerify { sender.send(any()) }
        assertEquals(someEvent, resultEvent)
        assert(resultEvent is ClickstreamEvent)
        assertEquals(someEvent.uiProperties, (resultEvent as ClickstreamEvent).uiProperties)
        assertEquals(someEvent.eventProperties, (resultEvent as ClickstreamEvent).eventProperties)
    }

}
