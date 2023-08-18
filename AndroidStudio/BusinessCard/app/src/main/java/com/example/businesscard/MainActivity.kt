package com.example.businesscard

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(         // Center Surface
                modifier = Modifier.padding(24.dp)
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Surface(
                        modifier = Modifier.height(96.dp).width(96.dp).fillMaxSize(),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.android_logo),
                            contentDescription = "Business Logo"
                        )
                    }
                    Surface(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        color = Color.White
                    ) {
                        Text(
                            text = "Full Name",
                            fontWeight = FontWeight.Bold,
                            fontSize = 48.sp
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
            Surface(
                modifier = Modifier.padding(top = 48.dp).align(alignment = Alignment.CenterHorizontally)
            ) {           // Bottom surface
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
                                text = "+1-234-345-9876",
                                modifier = Modifier
                                    .align(alignment = Alignment.Bottom)
                                    .clickable { },

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
                            Surface(
                                modifier = Modifier,

                            ) {
                                Icon(
                                    imageVector = myAppIcon.Email,
                                    contentDescription = "Email address",
                                    )
                            }
                            Text(text = "admin@snifButt.edu")
                        }
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

@Preview(
    showBackground = true
)
@Composable
fun BusinessPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}