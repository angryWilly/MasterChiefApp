package com.example.abobusteam.screens

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.R

@Composable
fun DishRecipeScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
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
                        .size(32.dp),
                )
            }

            Text(
                text = "Выпечка", //заменить на категрию?
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            var favIconStyle by remember { mutableStateOf(Icons.Default.FavoriteBorder) }
            IconButton(
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
                        .size(38.dp),
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.cup_cake), //заменить на картинку с апи
            contentDescription = "Cupcake",
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
                text = "Кексы с какао",
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

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(Color(0xFFEEF4F8))
                .align(Alignment.CenterHorizontally)
                .padding(6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Энергетическая ценность",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )

                Row(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(end = 80.dp)
                    ) {
                        Text(
                            text = "Белки",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "10 г",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(end = 80.dp)
                    ) {
                        Text(
                            text = "Жиры",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "10 г",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Углеводы",
                            fontSize = 18.sp
                        )
                        Text(
                            text = "10 г",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }


        }

        Text(
            text = "Ингредиенты",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 24.dp, bottom = 16.dp)
        )

        val ingredients = listOf<Ingredients>(
            Ingredients("Мука пшеничная", "175 г"),
            Ingredients("Молоко", "150 мл"),
            Ingredients("Растительное масло", "60 мл"),
            Ingredients("Сахар", "100 г")
        )
        val ingredientsList by remember {
            mutableStateOf(ingredients)
        }
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 16.dp)
                .fillMaxWidth()
        ) {
            ingredientsList.forEach { ingredient ->
                IngredientRow(ingredient)
            }
        }

        Text(
            text = "Процесс приготовления",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(start = 24.dp, bottom = 16.dp)
        )

        val cookingSteps = listOf<CookingSteps>(
            CookingSteps(
                "Шаг 1",
                "elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Amet mattis vulputate enim nulla."
            ),
            CookingSteps(
                "Шаг 2",
                " sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Amet mattis vulputate enim nulla."
            ),
            CookingSteps(
                "Шаг 3",
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Amet mattis vulputate enim nulla."
            ),
            CookingSteps(
                "Шаг 4",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Amet mattis vulputate enim nulla."
            )
        )
        val stepsList by remember {
            mutableStateOf(cookingSteps)
        }
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 16.dp)
                .fillMaxWidth()
        ) {
            stepsList.forEach { step ->
                StepRow(step)
            }
        }

    }
}

@Composable
fun IngredientRow(ingredient: Ingredients) {
    Row {
        Text(text = ingredient.ingredient)

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(2f, 4f), 0f)
        Canvas(
            Modifier
                .weight(1f)
                .height(1.dp)
                .padding(top = 14.dp)
        ) {
            drawLine(
                color = Color.Black,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect
            )
        }

        Text(text = ingredient.calories)
    }
}

@Composable
fun StepRow(step: CookingSteps) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(Color(0xFF9EB2DA))
        ) {
            Text(
                text = step.step,
                modifier = Modifier
                    .padding(10.dp)
            )
        }

        Text(text = step.description)
    }
}

data class Ingredients(
    val ingredient: String,
    val calories: String
)

data class CookingSteps(
    val step: String,
    val description: String
)
