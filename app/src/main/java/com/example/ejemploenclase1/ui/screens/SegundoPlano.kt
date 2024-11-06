package com.example.ejemploenclase1.ui.screens

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.work.*
import java.util.concurrent.TimeUnit

// Worker para enviar la notificación en segundo plano
class NotificationWorker(context: Context, params: WorkerParameters) : Worker(context, params ) {
    override fun doWork(): Result {
        sendNotification()
        return Result.success()
    }

    private fun sendNotification( ) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "my_channel_id"

        // Crear el canal de notificación para versiones Android 8.0 y superiores
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "My Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Construir la notificación
        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Notificación de Prueba")
            .setContentText("Esta notificación se envió 15 segundos después de presionar el botón.")
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)  // Asegúrate de tener un ícono en res/drawable
            .build()

        notificationManager.notify(1, notification)
    }
}

// Función para programar la notificación con un retraso de 15 segundos
fun scheduleNotification(context: Context) {
    val notificationWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
        .setInitialDelay(15, TimeUnit.SECONDS) // Retraso de 15 segundos
        .build()

    WorkManager.getInstance(context).enqueue(notificationWorkRequest)
}

// Composable con un botón para programar la notificación
@Composable
fun NotificationButton(navController: NavController) {
    val context = LocalContext.current
    Button(onClick = { scheduleNotification(context) }) {
        Text("Programar Notificación")
    }
}
