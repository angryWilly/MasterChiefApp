package com.example.abobusteam.screens.dishRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.Recipe

@Composable
fun CaloriesBox(recipe: Recipe) {
    Box(
        modifier = Modifier
            .padding(start = 22.dp, top = 12.dp, bottom = 12.dp, end = 10.dp)
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(Color(0xFFEEF4F8))
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Энергетическая ценность",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

            Row(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(end = 80.dp)
                ) {
                    Text(
                        text = "Белки",
                        fontSize = 16.sp
                    )
                    Text(
                        text = recipe.nutrients.protein.toString() + " г",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(end = 80.dp)
                ) {
                    Text(
                        text = "Жиры",
                        fontSize = 16.sp
                    )
                    Text(
                        text = recipe.nutrients.fat.toString() + " г",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Углеводы",
                        fontSize = 16.sp
                    )
                    Text(
                        text = recipe.nutrients.carbohydrates.toString() + " г",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }


    }
}