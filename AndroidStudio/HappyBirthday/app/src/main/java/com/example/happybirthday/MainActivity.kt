package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Column(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                            Welcome(
                                size = 30f,
                                color = Color.Yellow
                            )
                        }
                        GreetingImage(message = "Alex", from = "Sid")
//                        GreetingText(name = "Alex", from = "Sid", type = Events.NA, size = 20f)
//                        GreetingText(name = "Alex", from = "Sid", type = Events.WC, size = 20f)
//                        GreetingText(name = "Alex", from = "Sid", type = Events.HA, size = 30f)
//                        GreetingText(name = "Alex", from = "Sid", type = Events.HB, size = 30f)
                    }
                }
            }
        }
    }
}


val readOnlyImageMenu = mapOf<String, String>("card1" to "R.drawable.androidparty")

@Composable
fun GreetingImage(message: String, from : String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = "Birthday"
        )
        GreetingText(name = message, from = from, type = Events.HA, size = 30f)
    }
}

@Composable
fun GreetingText(
    name: String,
    from: String,
    type: Events,
    size: Float,
    modifier: Modifier = Modifier
) {
    /*
    Check for type of event
    Add Appropriate Prefix
    */
    val greet = when (type) {
        Events.HB -> "Happy Birthday, "
        Events.HA -> "Happy Anniversary, "
        Events.WC -> "Welcome, "
        Events.NA -> "Namaste, "
    }
    Column {
        Text(
            text = "$greet$name!",
            modifier = Modifier.padding(8.dp),
            fontSize = size.sp,
            lineHeight = size.sp * 1.1f,
        )
        Text(
            text = "From $from",
            modifier = Modifier
                //            .align(alignment = Alignment.End)
                .padding(4.dp),
            fontSize = size.sp / 2f
        )
    }
}

@Composable
fun Welcome(
    size: Float,
    color: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Welcome to Android Studio Course!!",
        modifier = Modifier
            .background(color = Color.Cyan)
            .padding(10.dp),
        fontSize = size.sp,
        lineHeight = size.sp*1.2f,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Preview(
    name = "Preview",
    showBackground = false,
    showSystemUi = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
//        GreetingText(message = "Happy Birthday, Sam!")
        GreetingImage(message = "Alex", from = "Sid")
    }
}

enum class Events {
    HB, // Happy Birthday
    HA, // Happy Anniversary
    WC, // Welcome
    NA, // Namaste
}
