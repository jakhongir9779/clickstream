package analytics.sdk.test

import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.ClickstreamSdkImpl
import analytics.sdk.clickstream.builder.ClickstreamBuilder
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.clickstream.domain.model.ClickstreamEvent
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.common.extensions.multiParametersOf
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.properties.PropertiesProvider
import io.mockk.every
import io.mockk.mockk
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest


class ClickstreamTestRule : KoinTest, TestRule {

    var eventSender: AnalyticsEventSender = mockk(relaxed = true)
    var api: ClickstreamAnalyticsApi = mockk(relaxed = true)
    val dependencies = mockk<PlatformDependencies>(relaxed = true)
    val scheduler = mockk<AnalyticsJobScheduler>(relaxed = true)
    private lateinit var clickstream: ClickstreamSdkImpl
    override fun apply(base: Statement?, description: Description?): Statement {
        every { dependencies.utils } returns mockk(relaxed = true)
        every { dependencies.utils.initAllowed() } returns true
        val config = ClickstreamConfig()
        startKoin {
            modules(
                module {
                    factory<ClickstreamSdkImpl> {
                        ClickstreamSdkImpl(
                            dependencies = dependencies,
                            clickStreamConfig = config,
                            analyticsJobScheduler = scheduler,
                            propertiesProvider = null,
                            api = api,
                            sender = eventSender
                        )
                    }
                },
            )
        }

        initialize(
            koin = getKoin(),
            url = "",
            dependencies = dependencies,
            analyticsJobScheduler = scheduler,
            propertiesProvider = null,
            clickStreamConfig = config,
            requestHeaders = mapOf(),
        )

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

    fun initialize(
        koin: Koin,
        url: String,
        dependencies: PlatformDependencies,
        requestHeaders: Map<String, () -> String>,
        clickStreamConfig: ClickstreamConfig,
        analyticsJobScheduler: AnalyticsJobScheduler,
        propertiesProvider: PropertiesProvider?,
    ) {
        clickstream = koin.get<ClickstreamSdkImpl> {
            multiParametersOf(
                url,
                dependencies,
                requestHeaders,
                clickStreamConfig,
                analyticsJobScheduler,
                propertiesProvider
            )
        }
    }

    fun send(builder: ClickstreamBuilder.() -> ClickstreamEvent) {
        clickstream.send(builder)
    }

}