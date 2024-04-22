import SwiftUI
import clickstream

struct ContentView: View {
        
	var body: some View {
        
        Text("clickstream").onAppear() {
            
            ClickstreamSdk.shared.initialize(
                url: "https://clickstream-b2c.dev.cluster.kznexpess.com/api/analytics/v2/",
                requestHeaders: ["Authorization" : { "Bearer" }],
                config: ClickstreamConfig(
                    sizeOfBatch: 5,
                    sendDataPeriodicityInMinutes: 0.1
                ),
                propertiesProvider: PropertiesProvider(
                    appProps: ApplicationAnalyticsPropertyProvider(
                        values: [
                            //AppVersionProperty("app_version")
                        ]
                    ),
                    userProps: UserAnalyticsPropertyProvider(
                        values: [
                            //InstallIdProperty("install_id"),
                            AccountIdProperty(accountId: "account_id"),
                            AppsflyerIdProperty(appsflyerId: "appsflyer_id"),
                            FacebookIdProperty(facebookId: "facebook_id"),
                            FirebaseAppInstanceIdProperty(firebaseAppInstanceId: "firebase_app_instance_id"),
                            GoogleCidProperty(googleCid: "google_cid"),
                            LanguageProperty(language: "language"),
                            MindboxAnonIdProperty(muid: "mindbox_anon_id"),
                            MindboxIdProperty(mindboxId: "mindbox_id"),
                            MyTrackerInstanceIdProperty(myTrackerInstanceId: "mytracker_id"),
                        ]
                    ), 
                    deviceProps: DeviceAnalyticsPropertyProvider(
                        values: [
                            AppMetricaDeviceIdProperty(appMetricaDeviceId: "appmetrica_device_id")
                        ]
                    )
                )
            )
            
            ClickstreamSdk.shared.send { CB in
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
