package com.example.abobusteam

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        icon = Icons.Default.Home
    )

    object Search : BottomBarScreen(
        route = "search/{id}",
        icon = Icons.Default.Search
    )

    object Favorite : BottomBarScreen(
        route = "favorite/{category}",
        icon = Icons.Default.FavoriteBorder
    )
}