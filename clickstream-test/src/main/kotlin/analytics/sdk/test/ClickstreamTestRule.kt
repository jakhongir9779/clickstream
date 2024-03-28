package analytics.sdk.test

import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.Clickstream
import analytics.sdk.clickstream.ClickstreamSdkImpl
import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.serialization.json.jsonPrimitive
import org.junit.Assert.assertEquals
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement


class ClickstreamTestRule : TestRule {

    var eventSender: AnalyticsEventSender = mockk(relaxed = true)
    var api: ClickstreamAnalyticsApi = mockk(relaxed = true)
    val dependencies = mockk<PlatformDependencies>(relaxed = true)
    val scheduler = mockk<AnalyticsJobScheduler>(relaxed = true)
    val propertiesProvider = mockk<PropertiesProvider>(relaxed = true)
    private lateinit var clickstream: ClickstreamSdkImpl
    override fun apply(base: Statement?, description: Description?): Statement {
        every { dependencies.utils } returns mockk(relaxed = true)
        every { dependencies.utils.initAllowed() } returns true
        val config = ClickstreamConfig()
        clickstream = ClickstreamSdkImpl(
            dependencies = dependencies,
            clickStreamConfig = config,
            analyticsJobScheduler = scheduler,
            propertiesProvider = propertiesProvider,
            api = api,
            sender = eventSender
        )
        val field = Clickstream::class.java.getDeclaredField("clickstreamSdk")
        field.isAccessible = true
        field.set(Clickstream, clickstream)
//      Above code will run before tests
        return try {
            object : Statement() {
                @Throws(Throwable::class)
                override fun evaluate() {
                    base!!.evaluate()
                }
            }
        } finally {
//      use this block for after test cleanup logic
        }
    }

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        clickstream.send(builder)
    }

    fun verifyEventSent(
        event: String,
//        accountId: String? = null,
//        appsflyerId: String? = null,
//        facebookAnonId: String? = null,
//        firebaseAppInstanceId: String? = null,
//        googleCid: String? = null,
//        language: String? = null,
//        muid: String? = null,
//        mindboxId: String? = null,
//        myTrackerInstanceId: String? = null,
//        appmetricaDeviceId: String? = null,
//        timeZone: String? = null,
//        timestamp: String? = null,
        spaceId: String? = null,
        spaceName: String? = null,
//        spaceViewId: String? = null,
//        spacePreviousViewId: String? = null,
        spaceScreenSize: String? = null,
        spaceType: String? = null,
        widgetName: String? = null,
        widgetType: String? = null,
//        widgetText: String? = null,
//        widgetPrompt: String? = null,
//        widgetPosition: String? = null,
        sectionId: String? = null,
        sectionType: String? = null,
        sectionName: String? = null,
        sectionPosition: Long? = null,
        groupName: String? = null,
        groupPosition: Long? = null,
//        connectionType: String? = null,
        isInteractive: Boolean? = null,
        eventParams: List<Pair<String, String>>,
    ) {
        val resultEvent = slot<ClickstreamEvent>()
        coVerify { eventSender.send(capture(resultEvent)) }
        val actualEvent = resultEvent.captured
        val actualSpace = actualEvent.uiProperties?.space
        val actualWidget = actualEvent.uiProperties?.widget
        val actualSection = actualEvent.uiProperties?.section
        val actualGroup = actualEvent.uiProperties?.group
        assertEquals(resultEvent.captured.eventProperties?.type, event)


//        accountId?.let {
//            assertEquals(it, actualEvent.uiProperties)
//        }
//        appsflyerId?.let {
//            assertEquals(it, actualEvent.)
//        }
//        facebookAnonId?.let {
//            assertEquals(it, actualEvent.)
//        }
//        firebaseAppInstanceId?.let {
//            assertEquals(it, actualEvent.)
//        }
//        googleCid?.let {
//            assertEquals(it, actualEvent.)
//        }
//        language?.let {
//            assertEquals(it, actualEvent.)
//        }
//        muid?.let {
//            assertEquals(it, actualEvent.)
//        }
//        mindboxId?.let {
//            assertEquals(it, actualEvent.)
//        }
//        myTrackerInstanceId?.let {
//            assertEquals(it, actualEvent.)
//        }
//        appmetricaDeviceId?.let {
//            assertEquals(it, actualEvent.)
//        }
//        timeZone?.let {
//            assertEquals(it, actualEvent.)
//        }
//        timestamp?.let {
//            assertEquals(it, actualEvent.)
//        }
        spaceId?.let {
            assertEquals(it, actualSpace?.id)
        }
        spaceName?.let {
            assertEquals(it, actualSpace?.name)
        }
//        spaceViewId?.let {
//            assertEquals(it, actualSpace.type)
//        }
//        spacePreviousViewId?.let {
//            assertEquals(it, actualEvent.)
//        }
        spaceScreenSize?.let {
            assertEquals(it, actualSpace?.screenSize)
        }
        spaceType?.let {
            assertEquals(it, actualSpace?.type?.name)
        }
        widgetName?.let {
            assertEquals(it, actualWidget?.name)
        }
        widgetType?.let {
            assertEquals(it, actualWidget?.type?.name)
        }
//        widgetText?.let {
//            assertEquals(it, actualWidget?.text)
//        }
//        widgetPrompt?.let {
//            assertEquals(it, actualEvent.)
//        }
//        widgetPosition?.let {
//            assertEquals(it, actualEvent.)
//        }
        sectionId?.let {
            assertEquals(it, actualSection?.id)
        }
        sectionType?.let {
            assertEquals(it, actualSection?.type)
        }
        sectionName?.let {
            assertEquals(it, actualSection?.name)
        }
        sectionPosition?.let {
            assertEquals(it, actualSection?.position)
        }
        groupName?.let {
            assertEquals(it, actualGroup?.name)
        }
        groupPosition?.let {
            assertEquals(it, actualGroup?.position)
        }
//        connectionType?.let {
//            assertEquals(it, actualEvent.)
//        }
        isInteractive?.let {
            assertEquals(it, actualEvent.isInteractive)
        }

//        val eventParamsMap = eventParams.associate {
//            it.first to it.second
//        }
        eventParams.forEach { (key, value) ->
            val actualValue =
                actualEvent.eventProperties?.parameters?.get(key)?.jsonPrimitive?.content
            assertEquals(value, actualValue)
        }
    }
}