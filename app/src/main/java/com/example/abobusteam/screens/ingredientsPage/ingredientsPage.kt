package com.example.abobusteam.screens.ingredientsPage

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.GlobalListHolder.globalRecipeList
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking

@Composable
fun IngredientsScreen() {
    Column {
        SetupIngredientHeader()
        SetupIngredientBox()
    }
}


@Composable
fun SetupIngredientHeader() {
    Column {
        Row {
            Text(
                text = "Fridge",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp, bottom = 16.dp)
            )
        }
    }
}

@Composable
fun SetupIngredientBox() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(245, 247, 251))
        ) {

            Column {
                Row {
                    Text(
                        text = "Ingredients",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 24.dp, end = 16.dp)
                    )
                }

                IngredientsSection(ingredients = ingredientsList)
            }
        }
    }
}

@Composable
fun IngredientsSection(
    ingredients: List<String>
) {
    var selectedIngredientIndices by remember {
        mutableStateOf(setOf<Int>())
    }

    var selectedIngredientsText by remember {
        mutableStateOf("")
    }

    val navController = LocalNavController.current

    LazyVerticalGrid(
        columns = GridCells.Adaptive(120.dp)
    ) {
        items(ingredients.size) { index ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable {
                        selectedIngredientIndices = if (selectedIngredientIndices.contains(index)) {
                            selectedIngredientIndices - index
                        } else {
                            selectedIngredientIndices + index
                        }
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (selectedIngredientIndices.contains(index)) Color(158, 178, 218)
                        else Color(238, 244, 248)
                    )
                    .width(IntrinsicSize.Min)
            ) {
                Text(
                    text = ingredients[index],
                    color =
                    if (selectedIngredientIndices.contains(index)) Color.White
                    else Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
        }
    }

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(158, 178, 218),
            contentColor = Color.White
        ),
        onClick = {
            selectedIngredientsText = selectedIngredientIndices.joinToString(separator = ",") { ingredients[it] }
            val api = Request()
            globalRecipeList = runBlocking {
                api.getRecipesByIngredients(selectedIngredientsText, 20)
            }

            Log.e("omg", globalRecipeList.toString())

            navController?.navigate(route = "category/Ingredients")

        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Apply", fontSize = 24.sp)
        }
    }
}



val ingredientsList = listOf(
    "Chicken",
    "Salt",
    "Lemon",
    "Eggs",
    "Tomato",
    "Chili",
    "Cream",
    "Onion",
    "Olive oil",
    "Buckwheat",
    "Mushrooms",
    "Broccoli",
    "Сod fillets",
    "Garlic",
    "Bulgur",
    "Bacon",
    "Rice",
    "Flour",
    "Banana",
    "Milk",
    "Mayonnaise",
    "Pork",
    "Pomegranate",
    "Green peas",
)