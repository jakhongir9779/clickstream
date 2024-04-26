package analytics.sdk.clickstream.di

import analytics.sdk.clickstream.AnalyticsJobScheduler
import analytics.sdk.clickstream.ClickstreamSdkImpl
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApi
import analytics.sdk.clickstream.data.ClickstreamAnalyticsApiImpl
import analytics.sdk.clickstream.data.interactor.ClickstreamAnalyticsEventSender
import analytics.sdk.clickstream.data.mappers.MapEventToDatabaseEntity
import analytics.sdk.clickstream.domain.ClickstreamConfig
import analytics.sdk.common.AnalyticsEventSender
import analytics.sdk.common.extensions.MultiParameter
import analytics.sdk.database.ClickstreamDatabase
import analytics.sdk.database.Event
import analytics.sdk.database.gateway.LocalEventsGateway
import analytics.sdk.database.gateway.LocalEventsGatewayImpl
import analytics.sdk.platform.PlatformDependencies
import analytics.sdk.platform.properties.EventPropertiesDelegate
import analytics.sdk.properties.PropertiesProvider
import dbJsonAdapter
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val CommonKoinModule = module {
    lateinit var dependencies: PlatformDependencies
    lateinit var propertiesProvider: PropertiesProvider
    lateinit var eventPropertiesDelegate: EventPropertiesDelegate
    lateinit var config: ClickstreamConfig
    lateinit var url: String
    lateinit var requestHeaders: Map<String, () -> String>

    factory<ClickstreamSdkImpl> { (params: MultiParameter) ->
        dependencies = params.get<PlatformDependencies>()
        propertiesProvider = params.get<PropertiesProvider>()
        eventPropertiesDelegate = EventPropertiesDelegate(dependencies)
        config = params.get<ClickstreamConfig>()
        url = params.get<String>()
        requestHeaders = params.get<Map<String, () -> String>>()

        val httpClient = get<ClickstreamAnalyticsApi> {
            parametersOf(url, requestHeaders)
        }

        ClickstreamSdkImpl(
            dependencies = dependencies,
            clickStreamConfig = params.get<ClickstreamConfig>(),
            analyticsJobScheduler = params.get<AnalyticsJobScheduler>(),
            propertiesProvider = propertiesProvider,
            api = get<ClickstreamAnalyticsApi> { parametersOf(httpClient) },
            sender = get<AnalyticsEventSender>()
        )
    }

    single<ClickstreamConfig> { config }

    single<ClickstreamAnalyticsApi> {
        ClickstreamAnalyticsApiImpl(get())
    }

    single<LocalEventsGateway> {
        LocalEventsGatewayImpl(
            ClickstreamDatabase(
                driver = dependencies.databaseDriverFactory.createDriver(),
                eventAdapter = Event.Adapter(
                    eventJsonAdapter = dbJsonAdapter(),
                    propertiesMapJsonAdapter = dbJsonAdapter()
                )
            )
        )
    }

    single<AnalyticsEventSender> {
        ClickstreamAnalyticsEventSender(
            localEventsGateway = get(),
            mapEventToDatabaseEntity = MapEventToDatabaseEntity(
                dependencies = dependencies,
                propertiesProvider = propertiesProvider,
                eventPropertiesDelegate = eventPropertiesDelegate,
            )
        )
    }

}

