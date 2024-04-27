import SwiftUI
import clickstream


struct ContentView: View {
    let header  = "Bearer eyJraWQiOiIwcE9oTDBBVXlWSXF1V0w1U29NZTdzcVNhS2FqYzYzV1N5THZYb0ZhWXRNIiwiYWxnIjoiRWREU0EiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJVenVtIElEIiwiaWF0IjoxNjk4MTQ3NDUyLCJzdWIiOiI3MDRjNzczMC02NDM0LTQwMzctYTVkNS04YzZmZDE1NTY0MmUiLCJhdWQiOlsidXp1bV9hcHBzIiwibWFya2V0L2FuZHJvaWQiXSwiZXZlbnRzIjp7Im90cF9wYXNzZWQiOjE2OTc2MTIzMDN9LCJjdXN0b21lcl9pZCI6IjYyNTM2ZGIyLTVjZWUtNDcwZC1iNmM2LWY4MWY3YzAzMzYzOCIsInBob25lX251bWJlciI6Ijk5ODU1MDAxMTExMSIsImV4cCI6MTY5ODE1MDQ1Mn0.XXnwVmFbcZt1QhbGKSpk4RRrAS-ULpRKKU1eRcLTemVGkQHpTuQAa0nzLVDqIYv6qs4PDteP-esO0w-9GZ_ODA"

    var body: some View {

        Text("clickstream").onAppear() {

            Clickstream.shared.initialize(
                url: "https://clickstream-b2c.dev.cluster.kznexpess.com/api/analytics/v2/",
                dependencies : IosDependencies(),
                requestHeaders: ["Authorization": {header}],
                clickStreamConfig: ClickstreamConfig(sizeOfBatch: 5, sendDataPeriodicityInMinutes: 15.0, trackAppLifecycle: true, trackNotifications: true),
                analyticsJobScheduler: AnalyticsJobScheduler(),
                propertiesProvider: PropertiesProvider(
                    appProps: ApplicationAnalyticsPropertyProvider(
                        values: [
                            //                             AppVersionProperty(name: "app_version")
                        ]
                    ),
                    userProps: UserAnalyticsPropertyProvider(
                        values: [
                            InstallIdProperty(get: {
                                "install_id"
                            }),
                            AccountIdProperty(get: {
                                "account_id"
                            }),
                            AppsflyerIdProperty(get: {
                                "appsflyer_id"
                            }),
                            FacebookIdProperty(get: {
                                "facebook_id"
                            }),
                            FirebaseAppInstanceIdProperty(get: {
                                "firebase_id"
                            }),
                            GoogleCidProperty(get: {
                                "google_cid"
                            }),
                            MindboxAnonIdProperty(get: {
                                "mind_box_anon_id"
                            }),
                            MindboxIdProperty(get: {
                                "mind_box_id"
                            }),
                            MyTrackerInstanceIdProperty(get: {
                                "instance_id"
                            }),
                            LanguageProperty(get: {
                                "language_id"
                            }),
                        ]
                    ),
                    deviceProps: DeviceAnalyticsPropertyProvider(
                        values: [
                            AppMetricaDeviceIdProperty(appMetricaDeviceId: "appmetrica_device_id")
                        ]
                    )
                )
            )



            Clickstream.shared.send { CB in
                CB.space { SB in
                    SB.id(int: 1)
                    SB.name(name: "space_name")
                    SB.type(type: Space.Types.page)
                    return SB.screenSize(screenSize: "1920:1080")
                }
                CB.section { SB in
                    SB.id(int: 2)
                    SB.type(type: "section_type")
                    SB.name(name: "section_name")
                    return SB.position(int: 1)
                }
                CB.group { GB in
                    GB.name(name: "group_name")
                    return GB.position(int: 2)
                }
                CB.widget { WB in
                    WB.input(
                        name: "input_name",
                        text: "input_text",
                        prompt: "input_prompt",
                        position: KotlinInt(3)
                    )
                }
                CB.action(action: UiProperties.Action.show)
                CB.interaction(isInteractive: true)
                return CB.event { EB in
                    EB.type(type: "event_type")
                    return EB.parameter(key: "key", string: "value")
                }.build()
            }
        }

    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
