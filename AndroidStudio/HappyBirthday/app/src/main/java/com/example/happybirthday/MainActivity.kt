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
                    ComposeQuadrant()
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


@Composable
fun TaskManager() {
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

@Composable
fun ComposeQuadrant() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                color = Color(0xFFEADDFF)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Text Composable",
                        modifier = Modifier.padding(bottom =  16.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Displays text and follows the recommended " +
                                "Material Design guidelines.",
                        modifier = Modifier,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                color = Color(0xFFD0BCFF)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Image Composable",
                        modifier = Modifier.padding(bottom =  16.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Creates a composable that lays out and draws" +
                                " a given Painter class object.",
                        modifier = Modifier,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                color = Color(0xFFB69DF8)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Row Composable",
                        modifier = Modifier.padding(bottom =  16.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "A layout composable that places its children " +
                                "in a horizontal sequence.",
                        modifier = Modifier,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                color = Color(0xFFF6EDFF)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Column Composable",
                        modifier = Modifier.padding(bottom =  16.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "A layout composable that places its children " +
                                "in a vertical sequence.",
                        modifier = Modifier,
                        textAlign = TextAlign.Justify,
                    )
                }
            }
        }
    }
}


@Preview(
    name = "Preview",
    showBackground = false,
    showSystemUi = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
//        GreetingText(message = "Happy Birthday, Sam!")
//        GreetingImage(message = "Alex", from = "Sid")
//        TaskManager()
        ComposeQuadrant()
    }
}

enum class Events {
    HB, // Happy Birthday
    HA, // Happy Anniversary
    WC, // Welcome
    NA, // Namaste
}
