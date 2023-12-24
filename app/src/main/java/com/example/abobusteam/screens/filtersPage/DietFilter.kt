package com.example.abobusteam.screens.filtersPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.Recipe
import com.example.abobusteam.screens.homePage.StepsCategory

@Composable
fun SetupDiets() {

    Text(
        text = "Diets",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp)
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(90.dp),
        contentPadding = PaddingValues(5.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        items(Recipe.Diet.values()) { item ->
            GridItem(item.toString())
        }
    }
}

@Composable
fun GridItem(item: String) {
    Box(
        modifier = Modifier
            .background(Color(0xff9eb2da))
            .clip(RoundedCornerShape(10.dp))
    )
    {
        Text(
            text = item,
            modifier = Modifier.padding(10.dp)
        )
    }

}