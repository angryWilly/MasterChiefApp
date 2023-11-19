package com.example.abobusteam

import com.example.abobusteam.screens.MainPage
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


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

        }
        composable(route = BottomBarScreen.Favorite.route) {

        }
    }
}