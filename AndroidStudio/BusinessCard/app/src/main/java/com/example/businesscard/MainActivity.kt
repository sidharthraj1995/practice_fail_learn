package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
    val bgColor = 0xFF92d3b2
    val textColor = 0xFF08703c

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(bgColor)
    ) {
        Column(                             // Center Surface
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.padding(24.dp),
                color = Color.Transparent
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Surface(
                        modifier = Modifier
                            .height(96.dp)
                            .width(96.dp)
                            .fillMaxSize(),
                        color = Color.DarkGray
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.android_logo),
                            contentDescription = "Business Logo",
                            modifier = Modifier,
//                            colorFilter = ColorFilter.tint()
                        )
                    }
                    Surface(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        color = Color.Transparent
                    ) {
                        Text(
                            text = "Sidharth Raj",
//                            fontWeight = FontWeight.Bold,
                            fontSize = 48.sp
                        )
                    }
                    Surface(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        color = Color.Transparent
                    ) {
                        Text(
                            text = "Jack of All Trades",
                            color = Color(textColor),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
        Column(                                             // Bottom surface
            modifier = Modifier.padding(all = 24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 48.dp),
                color = Color.Transparent
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Surface(                        // Icons
                        modifier = Modifier.padding(),
                        color = Color.Transparent
                    ) {
                        Column(
                            modifier = Modifier.padding(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = myAppIcon.Phone,
                                contentDescription = "Phone Number",
                                modifier = Modifier.padding(12.dp),
                                tint = Color(textColor)
                            )
                            Icon(
                                imageVector = myAppIcon.Share,
                                contentDescription = "Social Media",
                                modifier = Modifier.padding(12.dp),
                                tint = Color(textColor)
                            )
                            Icon(
                                imageVector = myAppIcon.Email,
                                contentDescription = "Email address",
                                modifier = Modifier.padding(12.dp),
                                tint = Color(textColor)
                            )
                        }
                    }
                    Surface(                        // Text
                        modifier = Modifier,
                        color = Color.Transparent
                    ) {
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "+1-234-345-9876",
                                modifier = Modifier.padding(12.dp)
                            )
                            Text(
                                text = "@ButtSniffer",
                                modifier = Modifier.padding(12.dp)
                            )
                            Text(
                                text = "admin@snifButt.edu",
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
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