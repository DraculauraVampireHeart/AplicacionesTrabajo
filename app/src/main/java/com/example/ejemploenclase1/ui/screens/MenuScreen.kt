package com.example.ejemploenclase1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


@Composable
fun MenuScreen(navController: NavController){
    Column {
        Text(text = "This is a menu screen")
        Button(onClick = {navController.navigate("home")}) {
            
        }
    }
}