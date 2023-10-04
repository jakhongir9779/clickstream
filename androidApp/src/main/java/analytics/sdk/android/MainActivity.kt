package analytics.sdk.android

import analytics.sdk.clickstream.ClickstreamSdk
import analytics.sdk.database.AndroidDriverFactory
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.russhwolf.settings.SharedPreferencesSettings

class MainActivity : ComponentActivity() {

    val clickstreamSdk = ClickstreamSdk.initialize(
        "https://nexus.infra.cluster.kznexpess.com/repository/clickstream/",
        clickStreamPropProviders = null,
        appVersion = "1.0.0",
        packageName = packageName,
        driverFactory = AndroidDriverFactory(this),
        clickstreamSettings = SharedPreferencesSettings(
            getSharedPreferences("clickstream", Context.MODE_PRIVATE)
        ),
        eventPropertiesSettings = SharedPreferencesSettings(
            getSharedPreferences("event_properties", Context.MODE_PRIVATE)
        ),
        isDebug = BuildConfig.DEBUG
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    clickstreamSdk.send {
                        event { parameter(key = "name", value = "Android") }.build()
                    }
//                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
