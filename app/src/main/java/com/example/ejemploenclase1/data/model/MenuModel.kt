package com.example.ejemploenclase1.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuModel(
    val id:Int,
    var title: String,
    var option: String,
    val icon: ImageVector
)
