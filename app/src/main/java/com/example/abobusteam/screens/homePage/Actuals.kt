package com.example.abobusteam.screens.homePage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.RecipeListItem
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

@Composable
fun SetupActuals() {

    val request = Request()
    val randomOffset = Random.nextInt(0, 100)
    val recipes by remember {
        mutableStateOf(runBlocking {
            request.getRecipes(offset = randomOffset, count = 5)
        })
    }

    Text(
        text = "Actuals",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 16.dp, top = 24.dp)
    )


    LazyRow {
        itemsIndexed(recipes) { _: Int, item ->
            StepsActual(item)
        }
    }
}

@Composable
fun StepsActual(actuals: RecipeListItem) {
    val navController = LocalNavController.current
    Row(
        modifier = Modifier
            .padding(12.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                //.padding(10.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(Color(0xFFeef4f8))
                .clickable {
                    navController?.navigate(route = "search/" + actuals.id)
                }
        ) {
            Text(
                text = actuals.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .width(140.dp)
                    .padding(8.dp)
            )
        }
    }
}