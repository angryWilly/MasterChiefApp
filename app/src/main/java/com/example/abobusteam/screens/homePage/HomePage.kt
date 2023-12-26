package com.example.abobusteam.screens.homePage

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun MainScreen() {
    Column {
        SetupActuals()
        SetupNewRecipes()
        SetupWouldYouWantToCook()

    }
}

