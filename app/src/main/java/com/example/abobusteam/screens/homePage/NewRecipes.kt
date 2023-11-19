package com.example.abobusteam.screens.homePage

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.R

@Composable
fun SetupNewRecipes() {
    Row (
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "Новые рецепты",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row (
            modifier = Modifier
                .padding(end = 12.dp, top = 6.dp)
                .clickable {  }

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

    val newRecipes: List<Recipe> = listOf(
        Recipe(painterResource(id = R.drawable.pie_usa), "Американский тыквенный пирог с корицей"),
        Recipe(painterResource(id = R.drawable.solyanka), "Солянка"),
        Recipe(painterResource(id = R.drawable.solyanka), "Борщ"),
        Recipe(painterResource(id = R.drawable.solyanka), "Суп)"),
    )

    LazyRow(
        modifier = Modifier
            .padding(10.dp)
    ) {
        itemsIndexed(newRecipes) { _: Int, item ->
            StepsRecipes(item)
        }
    }
}

@Composable
fun StepsRecipes(recipe: Recipe) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column {
            val context = LocalContext.current
            Image(
                painter = recipe.image,
                contentDescription = recipe.name,
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp)
                    .clip(shape = RoundedCornerShape(size = 8.dp))
                    .clickable {
                        Toast
                            .makeText(context, recipe.name, Toast.LENGTH_SHORT)
                            .show()
                    }
            )

            Text(
                text = recipe.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                lineHeight = 14.sp,
                overflow = TextOverflow.Clip,
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)

            )
        }

    }
}

data class Recipe(
    val image: Painter,
    val name: String
)
