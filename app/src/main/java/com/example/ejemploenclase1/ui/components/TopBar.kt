package com.example.ejemploenclase1.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavController, backButton: Boolean) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        ),
        title = {
            Text(title)
        },
        navigationIcon = {
            if (backButton) { // Cierra correctamente el bloque 'if'
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Go to previous screen",
                        tint = Color.White
                    )
                }
            }
        } // Cierra correctamente el bloque 'navigationIcon'
    )
}