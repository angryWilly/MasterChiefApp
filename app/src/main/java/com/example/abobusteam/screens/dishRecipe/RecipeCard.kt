package com.example.abobusteam.screens.dishRecipe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.abobusteam.R
import com.example.abobusteam.Recipe

@Composable
fun RecipeCard(recipe: Recipe) {
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = recipe.image,
            contentDescription = recipe.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                //.fillMaxWidth()
                .width(350.dp)
                .height(220.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .clickable { }
        )
    }

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
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.cooking_time_img),
                contentDescription = "cooking time",
                tint = Color.Gray
            )
            Text(
                text = " " + recipe.readyInMinutes.toString() + " min",
                color = Color.Gray,
                fontSize = 18.sp,
            )
        }
/*        Icon(
            painter = painterResource(id = R.drawable.recipe_price),
            contentDescription = "recipe price",
            tint = Color.Gray
        )*/
        Text(
            text = "$" + recipe.pricePerServing.toString(),
            color = Color.Gray,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(end = 8.dp)
        )
    }
}