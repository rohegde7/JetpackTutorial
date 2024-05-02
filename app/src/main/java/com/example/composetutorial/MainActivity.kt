package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageCard(Message("Brother", "Enjoy Life, Eat Chicken"))
                }
            }
        }
    }
}

data class Message(
    val name: String,
    val message: String,
)

@Composable
fun MessageCard(message: Message, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(250.dp)
            .height(60.dp)
            .padding(4.dp)
    ) {
        Row(
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "This is your profile pic",
                modifier = modifier
                    .size(40.dp)
                    .shadow(elevation = 20.dp, shape = CircleShape)
                    .clip(CircleShape)
                    .border(2.dp, color = MaterialTheme.colorScheme.tertiary, shape = CircleShape)
                    .align(Alignment.Top),
            )

            Spacer(modifier = modifier.size(8.dp))

            Column(
                modifier = modifier.padding(2.dp)
            ) {
                Text(
                    text = "Welcome ${message.name}",
                    modifier = modifier
                        .align(Alignment.Start),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = MaterialTheme.colorScheme.secondary,
                )
                Text(
                    text = "A sweet message for you: ${message.message}",
                    modifier = modifier
                        .align(Alignment.Start),
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Surface(
//            color = Color.Green,
//            shadowElevation = 100.dp,
            tonalElevation = 100.dp,
            modifier = Modifier.padding(4.dp).fillMaxSize()
        ) {
            MessageCard(Message("Rohit", "Bolo Balle Balle"))
        }
    }
}