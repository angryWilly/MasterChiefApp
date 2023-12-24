package com.example.abobusteam

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.abobusteam.screens.DishRecipeScreen
import com.example.abobusteam.screens.SearchScreen
import com.example.abobusteam.screens.categoryPage.CategoryPage
import com.example.abobusteam.screens.homePage.MainPage
import com.example.abobusteam.screens.ingredientsPage.IngredientsPage


@Composable
fun BottomNavGraph(navController: NavHostController?) {

    if (navController != null) {
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route
        ) {
            composable(route = BottomBarScreen.Home.route) {
                MainPage()
            }
            composable(
                route = BottomBarScreen.Search.route,
            ) {
                SearchScreen()
            }
            composable(
                route = BottomBarScreen.Ingredients.route
            ) {
                IngredientsPage()
            }
            composable(
                route = "category/{category}",
                arguments = listOf(navArgument("category") {
                    type = NavType.StringType
                })
            ) {
                if (it.arguments?.getString("category") != null)
                    CategoryPage(it.arguments?.getString("category"))
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