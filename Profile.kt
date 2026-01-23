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
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme

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
            Spacer(modifier = Modifier.height(4.dp))
            Text("This is my profile")
        }
        Spacer(modifier = Modifier.width(40.dp))
        Button(onClick = onNavigateToMainScreen) {
            Text(text = "<- Back")
        }
    }
}


