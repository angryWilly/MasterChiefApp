package com.example.abobusteam.screens.filtersPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.GlobalListHolder
import com.example.abobusteam.GlobalListHolder.globalRecipeList
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.Recipe
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking

//import com.example.abobusteam.screens.homePage.SetupPopular
//import com.example.abobusteam.screens.homePage.SetupCost
//import com.example.abobusteam.screens.homePage.SetupCookingTime

@Composable
fun FiltersScreen() {

    var scrollState = rememberScrollState()
    val navController = LocalNavController.current

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {

        var inputFilters = InputFilters()

        SetupFiltersHeader()
        Column(

        ) {
            SetupDishCost(inputFilters)
            SetupCalories(inputFilters)
            SetupDiets(inputFilters)
            SetupType(inputFilters)
        }
        Spacer(modifier = Modifier.weight(1f))

        ExtendedFloatingActionButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(24.dp)
                .fillMaxWidth(),
            onClick = {
                globalRecipeList.clear()
                val api = Request()
                var sendCat = ""
                GlobalListHolder.minCost = if(inputFilters.minCost.isNotEmpty()) inputFilters.minCost.toInt() else Int.MIN_VALUE
                GlobalListHolder.maxCost = if(inputFilters.maxCost.isNotEmpty()) inputFilters.maxCost.toInt() else Int.MAX_VALUE

                globalRecipeList = runBlocking {
                    val minCalories = if (inputFilters.minCalory.isNotEmpty()) inputFilters.minCalory.toInt() else 0
                    val maxCalories = if (inputFilters.maxCalory.isNotEmpty()) inputFilters.maxCalory.toInt() else 9999
                    val recType = if (inputFilters.dishType.isNotEmpty()) getTypeFromString(inputFilters.dishType) else Recipe.Type.Default
                    val recDiet = if (inputFilters.dietFilter.isNotEmpty()) getDietFromString(inputFilters.dietFilter) else Recipe.Diet.Default
                    sendCat = "$recType $recDiet"
                    api.getRecipes(
                        type = recType!!,
                        minCalories = minCalories,
                        maxCalories = maxCalories,
                        diet = recDiet!!,
                        count = 100)
                }
                navController?.navigate(route = "category/$sendCat")
            }) {

            Text(
                text = "Apply",
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(8.dp)
            )

        }
    }
}

fun getTypeFromString(input: String): Recipe.Type? {
    return Recipe.Type.values().find { it.value == input }
}
fun getDietFromString(input: String): Recipe.Diet? {
    return Recipe.Diet.values().find { it.value == input }
}

data class InputFilters(
    var minCost: String = "",
    var maxCost: String = "",
    var minCalory: String = "",
    var maxCalory: String = "",
    var dietFilter: String = "",
    var dishType: String = ""
) {
    fun updateDishMinCost(newMinCost: String) {
        minCost = newMinCost
    }

    fun updateDishMaxCost(newMaxCost: String) {
        maxCost = newMaxCost
    }

    fun updateminCalories(newMinCalory: String) {
        minCalory = newMinCalory
    }

    fun updatemaxCalories(newMaxCalory: String) {
        maxCalory = newMaxCalory
    }

    fun updateDiets(newDietFilter: String) {
        dietFilter = newDietFilter
    }

    fun updateDishType(newDietFilter: String) {
        dishType = newDietFilter
    }
}