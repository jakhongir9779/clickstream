package uz.uzum.mobile.analytics.sdk.android

import analytics.sdk.clickstream.Clickstream
import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.space.Space
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendSomeEvent()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Column {
                        GreetingView("Clickstream SDK app")
                        Button(onClick = ::sendSomeEvent) {
                            Text("Click Me to send some event!")
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Button(onClick = ::sendDeeplinkEvent) {
                            Text("Click Me to send DEEPLINK event!")
                        }
                    }
                }
            }
        }
    }

    private fun sendDeeplinkEvent() {
        Clickstream.deeplinkOpened("https://uzum.uz/ru?utm_source=uzum_bank&utm_medium=ecosystem_referral&utm_campaign=banner_in_menu")
    }

    private fun sendSomeEvent() {
        Clickstream.send {
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
                button(name = "button_name", text = "button_text", position = null)
                image(name = "", url = "", position = null)
                select(name = "", text = "", position = null)
                text(name = "", text = "", position = null)
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
                type("event_type")
                parameter(
                    key = "parameter_key", value = "parameter_value"
                )
            }.build()
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        text = text
    )
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
