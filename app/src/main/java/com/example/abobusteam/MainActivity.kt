package com.example.abobusteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.abobusteam.ui.theme.AbobusTeamTheme

val LocalNavController = compositionLocalOf<NavHostController?> { null }
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbobusTeamTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(LocalNavController provides navController) {
                    MainScreen()
                }
            }
        }
    }
}

object GlobalListHolder {
    var globalRecipeList = mutableListOf<RecipeListItem>()
    var minCost = Int.MIN_VALUE
    var maxCost = Int.MAX_VALUE
}
