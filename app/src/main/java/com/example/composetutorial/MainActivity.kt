package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                ComposeTutorialTheme {
                    Conversation(messages = conversation)
                }
            }
        }
    }
}

data class Message(
    val name: String,
    val message: String,
)

val conversation = listOf(
    Message("Rohit", "Hello jinda raho beta kya kare kaise ho jai hind ok bye tata helllo hellllo"),
    Message("Rohit", "Hello jinda raho beta kya kare kaise ho jai hind ok bye tata helllo hellllo"),
    Message("Rohit", "Hello jinda raho beta kya kare kaise ho jai hind ok bye tata helllo hellllo"),
    Message("Rohit", "Hello jinda raho beta kya kare kaise ho jai hind ok bye tata helllo hellllo"),
    Message("Rohit", "Hello jinda raho beta kya kare kaise ho jai hind ok bye tata helllo hellllo"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
    Message("Rohit", "Hello"),
)

@Composable
fun MessageCard(message: Message, modifier: Modifier = Modifier) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val surfaceColor by animateColorAsState(
        if (isExpanded) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primary
    )

    Box(
        modifier = modifier
            .padding(4.dp)
    ) {
        Row {
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
                modifier = modifier
                    .padding(2.dp)
                    .clickable { isExpanded = !isExpanded },
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

                Spacer(modifier = modifier.size(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.small,
                    shadowElevation = 4.dp,
                    color = surfaceColor,
                    modifier = modifier.animateContentSize().padding(1.dp),
                ) {
                    Text(
                        text = "A sweet message for you: ${message.message}",
                        modifier = modifier
                            .align(Alignment.Start)
                            .padding(8.dp),
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1
                    )
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        messages.forEach {
            item {
                MessageCard(message = it)
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Preview(name = "Light Mode")
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Surface(
            tonalElevation = 200.dp
        ) {
            MessageCard(Message("Rohit", "Bolo Balle Balle"))
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(messages = conversation)
    }
}