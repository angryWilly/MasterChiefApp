package com.example.abobusteam.screens.filtersPage

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
//import com.example.abobusteam.screens.homePage.SetupPopular
//import com.example.abobusteam.screens.homePage.SetupCost
//import com.example.abobusteam.screens.homePage.SetupCookingTime

@Composable
fun FiltersPage() {
    Column {
        SetupFiltersHeader()
        SetupDishCost()
        SetupCalories()
        SetupDiets()
    }
}