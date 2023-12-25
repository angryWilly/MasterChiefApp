package com.example.abobusteam

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.abobusteam.screens.SearchScreen.Empty
import com.example.abobusteam.screens.filtersPage.FiltersPage
import com.example.abobusteam.screens.ingredientsPage.IngredientsPage


@Composable
fun BottomNavGraph(navController: NavHostController?) {

    if (navController != null) {
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route
        ) {
            composable(route = BottomBarScreen.Home.route) {
                FiltersPage()

            }
            composable(
                route = BottomBarScreen.Search.route,
            ) {
                Empty()
            }
            composable(
                route = BottomBarScreen.Ingredients.route
            ) {
                IngredientsPage()
            }
        }
    }
}