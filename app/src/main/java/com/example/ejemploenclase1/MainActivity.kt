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
import androidx.navigation.NavType
import androidx.navigation.activity
import androidx.navigation.navArgument
import com.example.ejemploenclase1.network.NetworkMonitorScreen
import com.example.ejemploenclase1.ui.components.ManageServiceScreen
import com.example.ejemploenclase1.ui.location.HomeView
import com.example.ejemploenclase1.ui.location.MapsSearchView
import com.example.ejemploenclase1.ui.location.SearchViewModel
import com.example.ejemploenclase1.ui.screens.AgendaScreen
import com.example.ejemploenclase1.ui.screens.BiometricsScreen
import com.example.ejemploenclase1.ui.screens.CameraScreen
import com.example.ejemploenclase1.ui.screens.Components
import com.example.ejemploenclase1.ui.screens.ContactsCalendar
import com.example.ejemploenclase1.ui.screens.LoginScreen
import com.example.ejemploenclase1.ui.screens.NotificationButton



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val searchVM = SearchViewModel() // Instancia de SearchViewModel
        setContent {
            ComposeMultiScreenApp(this, searchVM)
        }
    }
}

@Composable
fun ComposeMultiScreenApp(activity: AppCompatActivity, searchVM: SearchViewModel) {
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController, activity, searchVM)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, activity: AppCompatActivity, searchVM: SearchViewModel) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("calendarcontacts") { ContactsCalendar(navController) }
        composable("camera") { CameraScreen(navController = navController) }
        composable("components") { Components(navController) }
        composable("login") { LoginScreen(navController) }
        composable("segundo_plano") { NotificationButton(navController) }
        composable("biometrics") { BiometricsScreen(navController = navController, activity = activity) }
        composable("Network") { NetworkMonitorScreen(navController = navController, activity = activity) }

        // Ruta para MapsSearchView que recibe latitud, longitud y dirección como argumentos
        composable(
            "MapsSearchView/{lat}/{long}/{address}",
            arguments = listOf(
                navArgument("lat") { type = NavType.FloatType },
                navArgument("long") { type = NavType.FloatType },
                navArgument("address") { type = NavType.StringType }
            )
        ) {
            val lat = it.arguments?.getFloat("lat") ?: 0.0f
            val long = it.arguments?.getFloat("long") ?: 0.0f
            val address = it.arguments?.getString("address") ?: ""
            MapsSearchView(lat.toDouble(), long.toDouble(), address)
        }
        composable("Home") {
            HomeView(navController, searchVM)
        }

        composable("manage-service/{serviceId}"){
                backStackEntry -> val serviceId = backStackEntry.arguments?.getString("serviceId")
            ManageServiceScreen(navController, serviceId = serviceId)
        }
    }
}







