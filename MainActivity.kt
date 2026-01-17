package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigation.ui.theme.NavigationTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme

import android.content.res.Configuration

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                MyNavHost()
            }
        }
    }
}

data class Message(val author: String, val body: String)


// Shows the message with users image, name and text.
@Composable
fun MessageCard(msg: Message){
    // Padding around the message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            // Here we choose the image and edit its properties
            painter = painterResource(R.drawable.minecraft_2024_cover_art),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        // Adds horizontal space between image and columns
        Spacer(modifier = Modifier.width(8.dp))
        // Toggles the isExpanded variable when we click on this Column
        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge)

            // Vertical space between author and message
            Spacer(modifier = Modifier.width(4.dp))

            ExpandMessage(msg.body)
        }
    }
}

// Handles message expansion
@Composable
fun ExpandMessage(text: String) {
    var isExpanded by remember { mutableStateOf(false) }
    // Toggles the isExpanded variable when we click on this Column
    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
            Text(
                text = text,
                modifier = Modifier.padding(all = 4.dp),
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}

// Shows the conversation stored in SampleData using MessageCard
@Composable
fun Conversation(messages: List<Message>, onOpenProfilePage: () -> Unit){
    Column {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
        Button(onClick = onOpenProfilePage) {
            Text("To Profile")
        }
    }
}

// Shows the Profile page of the user
@Composable
fun ProfileScreen(onNavigateToMainScreen: () -> Unit) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            // Here we choose the image and edit its properties
            painter = painterResource(R.drawable.minecraft_2024_cover_art),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        // Toggles the isExpanded variable when we click on this Column
        Column {
            Text(
                text = "Pasi",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            // Vertical space between author and message
            Spacer(modifier = Modifier.width(4.dp))
            Text("This is my profile")
        }
    }
    Button(onClick = onNavigateToMainScreen) {
        Text(text = "Back to MainScreen")
    }
}

@Serializable
object MainScreen
@Serializable
object ProfilePage

// Handles the navigation between Conversation and ProfileScreen
@Composable
fun MyNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MainScreen) {
        composable<MainScreen> {
            Conversation(SampleData.conversationSample,
                onOpenProfilePage = {navController.navigate(ProfilePage) }
            )
        }
        composable<ProfilePage> {
            ProfileScreen(onNavigateToMainScreen = { navController.popBackStack() }
            )
        }
    }
}

