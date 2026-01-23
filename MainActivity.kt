package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigation.ui.theme.NavigationTheme

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

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

@Serializable
object MainScreen
@Serializable
object ProfilePage


// Handles the navigation between MainPage and Profile
@Composable
fun MyNavHost(modifier: Modifier= Modifier,
              navController: NavHostController = rememberNavController()) {

    NavHost(modifier=modifier,
        navController = navController,
        startDestination = MainScreen) {

        composable<MainScreen> {
            Conversation(SampleData.conversationSample,
                onNavigateToProfilePage = { navController.navigate(route=ProfilePage) })
        }

        composable<ProfilePage> {
            ProfileScreen(onNavigateToMainScreen = { navController.popBackStack() })
        }
    }
}


