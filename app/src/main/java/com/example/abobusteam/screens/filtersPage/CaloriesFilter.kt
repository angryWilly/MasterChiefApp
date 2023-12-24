package com.example.abobusteam.screens.filtersPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetupCalories() {

    Text(
        text = "Calories",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp)
    )

    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        BasicTextField(
            value = "Min значение",
            onValueChange = { },
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)
        )

        BasicTextField(
            value = "Max значение",
            onValueChange = { },
            modifier = Modifier
                .weight(1f)

        )
    }
}