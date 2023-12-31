package com.example.abobusteam.screens.dishRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(400.dp)
            .padding(start = 22.dp, top = 12.dp, bottom = 12.dp, end = 10.dp)
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .background(Color(0xFFEEF4F8))
            .padding(10.dp)
    ) {
        Column(

        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Nutrition",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column(

                ) {
                    Text(
                        text = "Protein",
                        fontSize = 16.sp
                    )
                    Text(
                        text = recipe.nutrients.protein.toString() + " g",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                    Text(
                        text = "Fat",
                        fontSize = 16.sp
                    )
                    Text(
                        text = recipe.nutrients.fat.toString() + " g",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Carbohydrates",
                        fontSize = 16.sp
                    )
                    Text(
                        text = recipe.nutrients.carbohydrates.toString() + " g",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }


    }
}