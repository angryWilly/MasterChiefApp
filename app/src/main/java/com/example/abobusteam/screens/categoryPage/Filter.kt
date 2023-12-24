package com.example.abobusteam.screens.categoryPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.R
import com.example.abobusteam.RecipeListItem

@Composable
fun SetFilter(recipeList: List<RecipeListItem>) {
    val context = LocalContext.current
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
    }
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
            .padding(18.dp)
    ) {
        Box {
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .padding(end = 10.dp)
                    .clip(shape = RoundedCornerShape(size = 10.dp))
            )
        }
        Column {
            Row(
                modifier = Modifier
                    .padding(bottom = 12.dp)
            ) {
                Text(
                    text = recipe.title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable{
                            navController?.navigate(route = "recipe/" + recipe.id)
                        }
                )
                /*                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "30 $",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )*/
            }
            var favIconStyle by remember { mutableStateOf(Icons.Default.FavoriteBorder) }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    if (favIconStyle == Icons.Default.FavoriteBorder)
                        favIconStyle = Icons.Default.Favorite
                    else
                        favIconStyle = Icons.Default.FavoriteBorder
                }) {
                Icon(
                    imageVector = favIconStyle,
                    contentDescription = "Back Button",
                    tint = Color(0xFFFF98AA),
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.White)
                )
            }

            /*Row(
                modifier = Modifier
                    .padding(bottom = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calories_image),
                    contentDescription = "calories_image",
                    tint = Color.Gray
                )
                Text(
                    text = "100 кКал",
                    color = Color.Gray
                )
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.cooking_time_img),
                    contentDescription = "cock_time",
                    tint = Color.Gray
                )
                Text(
                    text = "1 ч",
                    color = Color.Gray
                )
            }*/
        }
    }

}