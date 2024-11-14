package com.example.ejemploenclase1.network

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@Composable
fun NetworkMonitorScreen(navController: NavController, activity: AppCompatActivity) {
    val context = LocalContext.current

    val wifiManager = remember {
        context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }
    val connectivityManager = remember {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    val networkMonitor = remember { NetworkMonitor(wifiManager, connectivityManager, activity) }


    networkMonitor.NetworkMonitorScreen()

    val requestPermissionsLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        ) {
            Toast.makeText(context, "Permisos necesarios concedidos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Permisos necesarios no concedidos", Toast.LENGTH_SHORT).show()
        }
    }

    // Función que solicita permisos
    fun requestPermissionsIfNeeded() {
        val permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ).filter {
            ContextCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
        }
        if (permissions.isNotEmpty()) {
            requestPermissionsLauncher.launch(permissions.toTypedArray())
        }
    }

    // Solicita permisos al iniciar
    LaunchedEffect(Unit) {
        requestPermissionsIfNeeded()
    }

    // Llama al composable de monitoreo de red de NetworkMonitor
    networkMonitor.NetworkMonitorScreen()
}

@Composable
fun NetworkImage(isHighQuality: Boolean) {
    val imageUrl = if (isHighQuality) {
        "https://st4.depositphotos.com/5906210/40964/i/450/depositphotos_409642058-stock-photo-smoky-sunset-santa-cruz-mountains.jpg"
    } else {
        "https://st4.depositphotos.com/5906210/40964/i/150/depositphotos_409642058-stock-photo-smoky-sunset-santa-cruz-mountains.jpg"
    }

    Image(
        painter = rememberImagePainter(data = imageUrl),
        contentDescription = "Imagen de Red",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun ConnectionCard(title: String, content: String, networkSpeed: Int? = null) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
            Text(
                text = content,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            networkSpeed?.let {
                Text(
                    text = "Velocidad de Red: $it kbps",
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
