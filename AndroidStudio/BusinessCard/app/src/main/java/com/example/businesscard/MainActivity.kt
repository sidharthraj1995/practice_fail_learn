package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val myAppIcon = Icons.Rounded

    Surface(
        modifier = Modifier,
        color = Color.Black
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(         // Center Surface
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Surface {
                        Image(
                            painter = painterResource(id = R.drawable.android_logo),
                            contentDescription = "Company Logo"
                        )
                    }
                    Surface(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        color = Color.White
                    ) {
                        Text(
                            text = "Full Name",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Surface(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        color = Color.White
                    ) {
                        Text(text = "Title")
                    }
                }
            }
        }
        Surface {           // Bottom surface
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Surface(
                    modifier = Modifier,
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Icon(
                            imageVector = myAppIcon.Phone,
                            contentDescription = "Phone Number",
                            modifier = Modifier.align(alignment = Alignment.Top)
                        )
                        Text(
                            text = "+1 234 345 9876",
                            modifier = Modifier.align(alignment = Alignment.Bottom)
                        )
                    }
                }
                Surface(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(
                            imageVector = myAppIcon.Share,
                            contentDescription = "Social Media",
                        )
                        Text(text = "@ButtSniffer")
                    }
                }
                Surface(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(
                            imageVector = myAppIcon.Email,
                            contentDescription = "Email address"
                        )
                        Text(text = "admin@snifButt.edu")
                    }
                }
                
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}