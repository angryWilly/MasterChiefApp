package com.example.abobusteam.screens.SearchScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.LocalNavController

@Composable
fun FilterBtn() {
    val navController = LocalNavController.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .clickable{navController?.navigate(route = "ingredients")}
    ) {
        Icon(
            imageVector = Icons.Default.List,
            contentDescription = "Filter List",
            modifier = Modifier
                .size(38.dp)
                .padding(end = 4.dp)
        )
        Text(
            text = "All filters",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}