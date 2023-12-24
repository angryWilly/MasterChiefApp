package com.example.abobusteam.screens.dishRecipe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.Recipe
import com.example.abobusteam.RecipeIngredient


@Composable
fun Ingredients(recipe: Recipe) {
    Text(
        text = "Ingredients",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 24.dp, bottom = 16.dp)
    )

    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        var firstIteration = true

        recipe.ingredients?.forEach { ingredient ->
            if (firstIteration) {
                firstIteration = false
            } else {
                IngredientRow(ingredient)
            }
        }
    }


}

@Composable
fun IngredientRow(ingredient: RecipeIngredient) {
    Row {
        Text(text = ingredient.name)

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(2f, 4f), 0f)
        Canvas(
            Modifier
                .weight(1f)
                .height(1.dp)
                .padding(top = 14.dp)
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }

        Text(text = "${ingredient.amount} ${ingredient.unit}")
    }
}
