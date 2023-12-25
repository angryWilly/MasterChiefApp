package com.example.abobusteam

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.abobusteam.screens.DishRecipeScreen
import com.example.abobusteam.screens.SearchScreen
import com.example.abobusteam.screens.categoryPage.CategoryScreen
import com.example.abobusteam.screens.filtersPage.FiltersScreen
import com.example.abobusteam.screens.homePage.MainScreen
import com.example.abobusteam.screens.ingredientsPage.IngredientsScreen


@Composable
fun BottomNavGraph(navController: NavHostController?) {

    if (navController != null) {
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route
        ) {
            composable(route = BottomBarScreen.Home.route) {
                MainScreen()
            }
            composable(
                route = BottomBarScreen.Search.route,
            ) {
                SearchScreen()
            }
            composable(
                route = "filters",
            ) {
                FiltersScreen()
            }
            composable(
                route = BottomBarScreen.Ingredients.route
            ) {
                IngredientsScreen()
            }
            composable(
                route = "category/{category}",
                arguments = listOf(navArgument("category") {
                    type = NavType.StringType
                })
            ) {
                if (it.arguments?.getString("category") != null)
                    CategoryScreen(it.arguments?.getString("category"))
            }
            composable(
                route = "recipe/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) {
                if (it.arguments?.getInt("id") != null)
                    DishRecipeScreen(it.arguments?.getInt("id"))
            }
        }
    }
}