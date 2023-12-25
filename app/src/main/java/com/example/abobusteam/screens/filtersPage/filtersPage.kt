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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.Recipe
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking

//import com.example.abobusteam.screens.homePage.SetupPopular
//import com.example.abobusteam.screens.homePage.SetupCost
//import com.example.abobusteam.screens.homePage.SetupCookingTime

@Composable
fun FiltersPage() {

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
                val api = Request()
                mutableStateOf(runBlocking {
                    api.getRecipes(
                        type = Recipe.Type.valueOf(inputFilters.dishType),

                        count = 30)
                })
                //navController?.navigate(route = "category/$value")
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