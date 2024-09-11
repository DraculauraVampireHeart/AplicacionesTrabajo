package com.example.ejemploenclase1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    Column {
        Text(text = "This is a new screen")
        Button(onClick = {navController.navigation("home")}) {
            
        }
    }
}