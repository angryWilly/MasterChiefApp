package com.example.abobusteam.screens.categoryPage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.RecipeListItem

@Composable
fun SetFilter(recipeList: List<RecipeListItem>) {
    /*    val context = LocalContext.current
      Row(
           modifier = Modifier
               .padding(start = 10.dp)
               .fillMaxWidth()
       ) {
           Text(
               text = "Popular",
               fontSize = 16.sp,
               color = Color.Gray,
               modifier = Modifier
                   .padding(start = 14.dp, bottom = 18.dp)
           )
           Icon(
               painter = painterResource(id = R.drawable.bot_arrow),
               contentDescription = "bot_arrow",
               tint = Color.Gray
           )
       }*/
    LazyColumn {
        items(recipeList) { recipe ->
            SetupImages(recipe)
        }
    }
}

@Composable
fun SetupImages(recipe: RecipeListItem) {
    val navController = LocalNavController.current
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {
                navController?.navigate(route = "recipe/" + recipe.id)
            }
    ) {
        Box {
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(140.dp)
                    .padding(end = 10.dp)
                    .clip(shape = RoundedCornerShape(size = 10.dp))
            )
        }

        Column {
            Row(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .height(60.dp)
            ) {
                Text(
                    text = recipe.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(
                    text = if (recipe.nutrients != null) recipe.nutrients?.calories.toString() + " cal" else "",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (recipe.pricePerServing > 0)  "$" + recipe.pricePerServing.toString() else "",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}