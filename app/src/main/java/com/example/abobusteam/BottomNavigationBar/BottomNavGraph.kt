package com.example.abobusteam

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.abobusteam.screens.DishRecipeScreen
import com.example.abobusteam.screens.homePage.MainPage


@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            MainPage()
        }
        composable(route = BottomBarScreen.Search.route) {
            DishRecipeScreen()
        }
        composable(route = BottomBarScreen.Favorite.route) {

        }
    }
}