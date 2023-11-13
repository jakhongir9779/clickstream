import SwiftUI
import clickstream

struct ContentView: View {
        
	var body: some View {
        
        Text("clickstream").onAppear() {
            
            ClickstreamSdk.shared.initialize(
                url: "https://clickstream-b2c.dev.cluster.kznexpess.com",
                propertiesProvider: nil,
                requestHeaders: ["Authorization" : { "Bearer" }]
            )
            
            ClickstreamSdk.shared.send { ClickstreamBuilder in
                ClickstreamBuilder
                    .event { EventPropertiesBuilder in
                        EventPropertiesBuilder.type(type: "CHECK_KMM")
                        EventPropertiesBuilder.parameter(key: "key1", string: "value1")
                        EventPropertiesBuilder.parameter(key: "key2", bool: true)
                        EventPropertiesBuilder.addIfNotNil(key: "key3", double: 1)
                        return EventPropertiesBuilder.addIfNotNil(key: "key4", int32: nil)
                    }
                    .build()
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
