package com.example.abobusteam.screens.categoryPage

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.RecipeListItem

//import com.example.abobusteam.screens.homePage.StepsActual

@Composable
fun SetupHeader(recipeList: List<RecipeListItem>, category:String?) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(top = 14.dp, start = 10.dp)
            .fillMaxWidth()
    ) {
        val navController = LocalNavController.current
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = {
                    Toast
                        .makeText(context, "Test", Toast.LENGTH_SHORT)
                        .show()
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable{
                            navController?.navigateUp()
                        },
                )
            }
            Text(
                text = "All recipe",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 46.dp)
            )
        }
    }

    Row(
        modifier = Modifier
            .padding(start = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = category!!,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 14.dp)
        )
    }

    val sHeader: List<String> = listOf(
        "До часа",
        "200 - 400 ккал",
        "Выпечка",
        "Диетическое",
        "Десерт"
    )

/*    LazyRow (
        modifier = Modifier
        .padding(start = 14.dp, end = 14.dp)){
        itemsIndexed(sHeader) { _: Int, item ->
            StepsCategories(item)
        }
    }*/
}

@Composable
fun StepsCategories(categories: String) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(start = 12.dp, top = 14.dp, bottom = 18.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(Color(0xff9eb2da))
            .clickable {
                Toast
                    .makeText(context, categories, Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Text(
            text = categories,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(10.dp)
        )
    }

}

