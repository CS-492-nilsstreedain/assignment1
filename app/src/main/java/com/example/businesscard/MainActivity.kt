/*
    Nils Streedain
    OSU
    CS 492
 */
package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Card(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Contact(icon: ImageVector, value: String, description: String, modifier: Modifier = Modifier) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = Color(0xFF0D5C2C),
            modifier = Modifier.padding(end = 24.dp)
        )
        Text(text = value, modifier = Modifier.padding(bottom = 16.dp))
    }
}

@Composable
fun Card(name: String, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFC8E3CA)),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier.size(125.dp).padding(8.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "Nils Streedain",
                fontSize = 48.sp,
                color = Color(0xFF0C1810),
                fontWeight = FontWeight.Light
            )
            Text(
                text = "CS 492 Student Extraordinaire",
                modifier = modifier,
                color = Color(0xFF0D5C2C),
                fontWeight = FontWeight.Bold
            )
        }
        Column {
            Contact(Icons.Filled.Phone, "+1 (234) 567-8910", "Phone Icon")
            Contact(Icons.Filled.Share, "@nilsstreedain", "Share Icon")
            Contact(Icons.Filled.Email, "streedan@oregonstate.edu", "Email Icon")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Card("Android")
    }
}