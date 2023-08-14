package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_task_completed),
                                contentDescription = null
                            )
                            Text(
                                text = "All tasks completed",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)

                            )
                            Text(
                                text = "Nice Work!",
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
    }
}


val readOnlyImageMenu = mapOf<String, Int>("card1" to R.drawable.androidparty)

@Composable
fun GreetingImage(
    message: String,
    from: String,
    size: Int,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = "Birthday",
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            name = message,
            from = from,
            type = Events.HA,
            size = size,
            modifier = Modifier
                .align(alignment = Alignment.Center)
        )
    }
}

@Composable
fun GreetingText(
    name: String,
    from: String,
    type: Events,
    size: Int,
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
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier,
    ) {
        Text(
            text = "$greet$name!",
            modifier = Modifier.padding(8.dp),
            fontSize = size.sp,
            lineHeight = size.sp * 1.1,
            textAlign = TextAlign.Center
        )
        Text(
            text = "From $from",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(4.dp),
            fontSize = size.sp / 2
        )
    }
}

@Composable
fun Welcome(
    size: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Welcome to Android Studio Course!!",
        modifier = Modifier
            .background(color = Color.Black)
//            .align(alignment = Alignment.CenterHorizontally)
//            .alpha(0.5f)
            .padding(10.dp),
        fontSize = size.sp,
        lineHeight = size.sp * 1.2,
        color = color,
        textAlign = TextAlign.Center,
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
//        GreetingImage(message = "Alex", from = "Sid")
    }
}

enum class Events {
    HB, // Happy Birthday
    HA, // Happy Anniversary
    WC, // Welcome
    NA, // Namaste
}
