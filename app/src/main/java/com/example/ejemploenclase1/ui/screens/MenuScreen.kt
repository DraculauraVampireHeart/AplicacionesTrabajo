package com.example.ejemploenclase1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun MenuScreen(navController: NavController){
    Column (
        modifier = Modifier
            .padding(top = 24.dp, start = 7.dp)
    ){

        Button(onClick = {navController.navigate("home")}) {
            Text(text = "This is a menu screen")
        }
        
        Button(onClick = {navController.navigate("components")}) {
            Text(text = "Go to components")
        }

        Button(onClick = {navController.navigate("login")}) {
            Text(text = "Login")
        }

        Button(onClick = {navController.navigate("segundo_plano")}) {
            Text(text = "Segundo Plano")
        }

        Button(onClick = {navController.navigate("biometrics")}) {
            Text(text = "Biometrics")
        }
    }
}