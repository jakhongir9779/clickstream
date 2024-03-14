package analytics.sdk.android

import analytics.sdk.clickstream.Clickstream
import analytics.sdk.clickstream.builder.UiProperties
import analytics.sdk.clickstream.builder.space.Space
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                    key = "parameter_key",
                    value = "parameter_value"
                )
            }.build()
        }

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView("Clickstream SDK app")

                    Button(onClick = ::sendSomeEvent) {
                        Text("Click Me to send some event!")
                    }
                }
            }
        }
    }

    private fun sendSomeEvent() {
        Clickstream.send {
            space {
                id(Random.nextLong())
                name("space_name")
                type(Space.Type.PAGE)
                screenSize("1920:1080")
            }
            action(UiProperties.Action.SHOW)
            interaction(true)
            event {
                type("event_type")
                parameter(
                    key = "parameter_key",
                    value = "parameter_value"
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
