package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
/*
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
*/
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigation.ui.theme.NavigationTheme
/*
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
*/
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
/*
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.navigation.dynamicfeatures.createGraph
*/
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


// Handles the navigation between Conversation and ProfileScreen
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

@Preview
@Composable
fun NavPreview(navController: NavHostController = rememberNavController()) {
    //ProfileScreen(onNavigateToMainScreen = { navController.popBackStack() })
    Conversation(SampleData.conversationSample, onNavigateToProfilePage = { navController.navigate(route=ProfilePage) })
}
