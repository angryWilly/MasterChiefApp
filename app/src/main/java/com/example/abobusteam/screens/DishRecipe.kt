package com.example.abobusteam.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.abobusteam.Request
import com.example.abobusteam.screens.dishRecipe.CaloriesBox
import com.example.abobusteam.screens.dishRecipe.Ingredients
import com.example.abobusteam.screens.dishRecipe.RecipeCard
import com.example.abobusteam.screens.dishRecipe.RecipeSteps
import com.example.abobusteam.screens.dishRecipe.TopBar
import kotlinx.coroutines.runBlocking

@Composable
fun DishRecipeScreen(id: Int?) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        val api = Request()
        val recipe by remember {
            mutableStateOf(runBlocking {
                api.getRecipe(id!!)
            })
        }
        TopBar()
        RecipeCard(recipe)
        CaloriesBox(recipe)
        Ingredients(recipe)
        RecipeSteps(recipe)
    }
}





