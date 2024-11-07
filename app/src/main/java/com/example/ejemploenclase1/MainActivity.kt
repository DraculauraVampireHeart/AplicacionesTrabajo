package com.example.ejemploenclase1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemploenclase1.ui.screens.HomeScreen
import com.example.ejemploenclase1.ui.screens.MenuScreen
import androidx.compose.foundation.layout.*
import androidx.navigation.activity
import com.example.ejemploenclase1.network.NetworkMonitorScreen
import com.example.ejemploenclase1.ui.screens.BiometricsScreen
import com.example.ejemploenclase1.ui.screens.Components
import com.example.ejemploenclase1.ui.screens.LoginScreen
import com.example.ejemploenclase1.ui.screens.NotificationButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMultiScreenApp(this)

        }
    }
}

@Composable
fun ComposeMultiScreenApp(activity: AppCompatActivity){
    val navController = rememberNavController()
    Surface(color = Color.White){
        SetupNavGraph(navController = navController, activity)
    }

}

@Composable
fun SetupNavGraph(navController: NavHostController, activity: AppCompatActivity){
    NavHost(navController = navController, startDestination = "menu"){
        composable("menu"){ MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("components"){ Components(navController) }
        composable("login"){ LoginScreen(navController) }
        composable("segundo_plano") { NotificationButton(navController) }
        composable("biometrics"){ BiometricsScreen(navController = navController, activity = activity)}
        composable("Network") { NetworkMonitorScreen(navController = navController, activity = activity) }

    }
}








