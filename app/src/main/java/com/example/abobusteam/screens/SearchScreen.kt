package com.example.abobusteam.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.abobusteam.screens.SearchScreen.SearchContent
import com.example.abobusteam.screens.SearchScreen.SearchTextHeader

@Composable
fun SearchScreen() {
    Column(
        Modifier.padding(top = 10.dp)
    ){
        SearchTextHeader()
        SearchContent()

    }
}