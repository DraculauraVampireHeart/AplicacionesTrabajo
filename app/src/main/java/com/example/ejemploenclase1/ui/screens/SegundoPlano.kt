package com.example.ejemploenclase1.ui.screens

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.navigation.NavController
import androidx.work.*
import java.util.concurrent.TimeUnit

// Worker para enviar la notificación en segundo plano
class NotificationWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        sendNotification()
        return Result.success()
    }

    private fun sendNotification() {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "my_channel_id"

        // Crear el canal de notificación para versiones Android 8.0 y superiores
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "My Channel",
                NotificationManager.IMPORTANCE_HIGH // IMPORTANCE_HIGH para notificación flotante
            ).apply {
                description = "Este es un canal de notificaciones de prueba"
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Construir la notificación con prioridad alta
        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Notificación de Prueba")
            .setContentText("Esta notificación se envió 5 segundos después de presionar el botón.")
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm) // Icono pequeño para la notificación
            .setPriority(NotificationCompat.PRIORITY_HIGH) // PRIORITY_HIGH para mostrar heads-up
            .setDefaults(NotificationCompat.DEFAULT_ALL) // Incluye sonido, vibración y luz de notificación
            .build()

        notificationManager.notify(1, notification)
    }
}

// Función para programar la notificación con un retraso de 5 segundos
fun scheduleNotification(context: Context) {
    val notificationWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
        .setInitialDelay(5, TimeUnit.SECONDS) // Retraso de 5 segundos
        .build()

    WorkManager.getInstance(context).enqueue(notificationWorkRequest)
}

// Función para verificar y solicitar permiso de notificación
@Composable
fun RequestNotificationPermission() {
    val context = LocalContext.current
    val permissionGranted = remember { mutableStateOf(false) }

    // Launcher para solicitar el permiso de notificación
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionGranted.value = isGranted
    }

    // Comprobar si el permiso ya está concedido
    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionGranted.value = ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            permissionGranted.value = true // No se necesita permiso en versiones anteriores
        }
    }

    // Botón para solicitar el permiso si no está concedido
    if (!permissionGranted.value) {
        Button(onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }) {
            Text("Solicitar Permiso de Notificación")
        }
    }
}

// Composable con un botón para programar la notificación
@Composable
fun NotificationButton(navController: NavController) {
    val context = LocalContext.current
    Column (
        modifier = Modifier
            .padding(top = 24.dp, start = 7.dp)
    ){
        // Botón para solicitar permiso de notificación
        RequestNotificationPermission()

        // Botón para programar la notificación
        Button(onClick = { scheduleNotification(context) }) {
            Text("Programar Notificación")
        }
    }
}

