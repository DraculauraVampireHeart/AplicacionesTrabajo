package com.example.ejemploenclase1.ui.screens

import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ejemploenclase1.ui.Biometrics.BiometricPromptManager

@Composable
fun BiometricsScreen(navController: NavController,activity:AppCompatActivity){
    val promptManager  by lazy{
        BiometricPromptManager(activity)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        val biometricResult by promptManager.promptResults.collectAsState(initial = null)

        val enrollLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = {
                println("Activity result: $it")
            }
        )

        LaunchedEffect(biometricResult) {
            if(biometricResult is BiometricPromptManager.BiometricResult.AuthenticationNotSet){
                if(Build.VERSION.SDK_INT >= 30){
                    val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(
                            Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                            BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                        )
                    }

                    enrollLauncher.launch(enrollIntent)
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Button(onClick = {
                promptManager.showBiometricPrompt(
                    title = "Sample prompt",
                    description = "Sample prompt description"
                )
            }) {
                Text(text = "Authenticate")
            }
            //Button(onClick = {navController.navigate("login")}){Text(text = "LOGIN") }
            biometricResult?.let{
                    result ->
                Text(
                    text = when(result){

                        is BiometricPromptManager.BiometricResult.AuthenticationError -> {
                            result.error
                        }
                        BiometricPromptManager.BiometricResult.AuthenticationFailed -> {
                            "Authentication failed"
                        }
                        BiometricPromptManager.BiometricResult.AuthenticationNotSet -> {
                            "Authentication not set"
                        }
                        BiometricPromptManager.BiometricResult.AuthenticationSuccess -> {
                            "Authentication success"
                        }
                        BiometricPromptManager.BiometricResult.FeatureUnavailable -> {
                            "Feature unavailable"
                        }
                        BiometricPromptManager.BiometricResult.HardwareUnavailable -> {
                            "Hardware unavailable"
                        }
                    }
                )

            }
        }
    }
}