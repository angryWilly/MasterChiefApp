package com.example.abobusteam

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

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

    object Ingredients : BottomBarScreen(
        route = "ingredients/{ingredients}",
        icon = Icons.Default.ShoppingCart
    )
}