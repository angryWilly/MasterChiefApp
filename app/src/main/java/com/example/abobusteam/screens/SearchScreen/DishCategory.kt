package com.example.abobusteam.screens.SearchScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.R
import com.example.abobusteam.Recipe.Type
import com.example.abobusteam.screens.homePage.Category

@Composable
fun DishCategory(){

    val category: List<Category> = getDishPhotos()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 192.dp),
        modifier = Modifier.padding(bottom = 10.dp)
    ){
        item(span = { GridItemSpan(2) }){
            FilterBtn()
        }
        itemsIndexed(category) { index, cat ->
            CategoryGrid(cat)
        }
    }
}

@Composable
fun CategoryGrid(category: Category){
    val navController = LocalNavController.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { navController?.navigate(route = "category/" + category.name) }
    ) {
        Image(
            painter = category.image,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(192.dp)
                .height(148.dp)
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                }
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            text = category.name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.BottomStart)
        )
    }
}

@Composable
fun getDishPhotos(): List<Category> {
    return listOf(
        Category(painterResource(id = R.drawable.main_course), Type.MainCourse.toString()),
        Category(painterResource(id = R.drawable.side_dish), Type.SideDish.toString()),
        Category(painterResource(id = R.drawable.breakfast), Type.Breakfast.toString()),
        Category(painterResource(id = R.drawable.lunch), Type.Lunch.toString()),
        Category(painterResource(id = R.drawable.dinner), Type.Dinner.toString()),
        Category(painterResource(id = R.drawable.salad), Type.Salad.toString()),
        Category(painterResource(id = R.drawable.snacks), Type.Snack.toString()),
        Category(painterResource(id = R.drawable.deserts), Type.Dessert.toString()),
        Category(painterResource(id = R.drawable.marinade), Type.Marinade.toString()),
        Category(painterResource(id = R.drawable.drink), Type.Drink.toString()),
        Category(painterResource(id = R.drawable.soup), Type.Soup.toString()),
        Category(painterResource(id = R.drawable.beverage), Type.Beverage.toString())
    )
}
