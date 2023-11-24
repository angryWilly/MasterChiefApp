package com.example.abobusteam.screens.dishRecipe

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.abobusteam.R
import com.example.abobusteam.Recipe

@Composable
fun RecipeCard(recipe: Recipe) {
    AsyncImage(
        model = recipe.image,
        contentDescription = recipe.title,
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    )

    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = recipe.title,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "$3",
            fontSize = 32.sp
        )
    }

    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.calories_image),
            contentDescription = "Calories",
            tint = Color.Gray
        )
        Text(
            text = "476 кКал",
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(end = 16.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.cooking_time_img),
            contentDescription = "cooking time",
            tint = Color.Gray
        )
        Text(
            text = "1 ч",
            color = Color.Gray,
            fontSize = 18.sp,
        )
    }
}