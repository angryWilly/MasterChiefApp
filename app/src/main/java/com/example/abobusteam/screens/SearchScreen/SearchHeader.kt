package com.example.abobusteam.screens.SearchScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchTextHeader() {
    Text(
        text = "All recipe",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 14.dp, start = 10.dp)
    )
}