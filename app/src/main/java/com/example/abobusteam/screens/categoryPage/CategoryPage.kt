package com.example.abobusteam.screens.categoryPage

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.abobusteam.GlobalListHolder
import com.example.abobusteam.GlobalListHolder.globalRecipeList
import com.example.abobusteam.Recipe

@Composable
fun CategoryScreen(category: String?) {
    /*    val recipe by remember {
            var foundType = Recipe.Type.Default
            if(Recipe.Type.values().find { it.value.equals(category, ignoreCase = true) } != null){
                foundType = findTypeByValue(category!!)!!
                mutableStateOf(runBlocking {
                    api.getRecipes(type = foundType, count = 30)
                })
            }
            else{
                mutableStateOf(runBlocking {
                    api.getRecipes(query = category!!, count = 30)
                })
            }
        }*/
    val recipe = globalRecipeList

    if (GlobalListHolder.maxCost != Int.MAX_VALUE || GlobalListHolder.minCost != Int.MIN_VALUE) {
        val iterator = recipe.iterator()

        while (iterator.hasNext()) {
            val rec = iterator.next()

            if (rec.pricePerServing > GlobalListHolder.maxCost || rec.pricePerServing < GlobalListHolder.minCost) {
                iterator.remove()
            }
        }
    }

    Column {
        SetupHeader(recipe, category)
        SetFilter(recipe)
        //SetupImages(recipe)

    }
}

fun findTypeByValue(value: String): Recipe.Type? {
    return Recipe.Type.values().find { it.value.equals(value, ignoreCase = true) }
}