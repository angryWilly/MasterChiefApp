package com.example.abobusteam.screens.categoryPage

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.abobusteam.Recipe
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking

@Composable
fun CategoryPage(category: String?) {
    val api = Request()
    val recipe by remember {
        val foundType = findTypeByValue(category!!)
        mutableStateOf(runBlocking {
            api.getRecipes(type = foundType!!, count = 30)
        })
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