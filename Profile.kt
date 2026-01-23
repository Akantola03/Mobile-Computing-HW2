package com.example.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment

@Composable
fun ProfileScreen(onNavigateToMainScreen: () -> Unit) {
    // Controls the buttons location
    Box(modifier = Modifier.fillMaxSize()){
        Button(onClick = onNavigateToMainScreen,
            modifier = Modifier
                .align(Alignment.TopStart)) {
            Text(text = "<- Back")
        }
    }

    Row(modifier = Modifier.padding(top = 60.dp, start = 8.dp, end = 8.dp)) {
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

        Column {
            Text(
                text = "Pasi",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("This is my profile")
        }
    }
}


