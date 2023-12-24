package com.example.abobusteam.screens.filtersPage
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetupFiltersHeader() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .wrapContentSize(align = Alignment.Center)
    ) {

        Text(
            text = "Filters",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 12.dp),
        )
    }
}