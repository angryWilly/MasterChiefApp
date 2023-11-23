package com.example.abobusteam.screens.homePage

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.abobusteam.R
import com.example.abobusteam.RecipeListItem
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

@Composable
fun SetupNewRecipes() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 12.dp,
                end = 12.dp,
                start = 12.dp)
    ) {
        Text(
            text = "Новые рецепты",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.weight(1f))

        val context = LocalContext.current
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .clickable {
                    Toast
                        .makeText(context, "Все", Toast.LENGTH_SHORT)
                        .show()
                }
        ) {

            Row(
                modifier = Modifier
                    .padding(6.dp)
            ) {
                Text(
                    text = "Все",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                Icon(
                    painter = painterResource(id = R.drawable.button_baseline_arrow_forward_24),
                    contentDescription = "Все"
                )

            }
        }
    }

    val request = Request()
    val randomOffset = Random.nextInt(0, 100)
    val recipes by remember {
        mutableStateOf(runBlocking {
            request.getRecipes(offset = randomOffset, count = 5)
        })
    }


    LazyRow (
        modifier = Modifier
        .padding(12.dp)
    ) {
        itemsIndexed(recipes) { _: Int, item ->
            StepsRecipes(item)
        }
    }
}

@Composable
fun StepsRecipes(recipe: RecipeListItem) {
    Column (
        modifier = Modifier
            .padding(end = 16.dp)
            .width(225.dp)
    ) {
        val context = LocalContext.current
        AsyncImage(
            model = recipe.image,
            contentScale = ContentScale.FillBounds,
            contentDescription = recipe.title,
            modifier = Modifier
                .height(125.dp)
                .clip(shape = RoundedCornerShape(size = 12.dp))
                .clickable {
                    Toast
                        .makeText(context, recipe.title, Toast.LENGTH_SHORT)
                        .show()
                }
        )

        Text(
            text = recipe.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            lineHeight = 14.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 8.dp)
                .height(40.dp)
        )
    }
}