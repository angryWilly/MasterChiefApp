package com.example.abobusteam.screens.filtersPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.Recipe

@Composable
fun SetupDiets(inputFilters: InputFilters) {

    var selectedType by remember { mutableStateOf(0) }


    Text(
        text = "Diets",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 20.dp)
    )

    val maxType = Recipe.Diet.values().size
    var typeNow = 0

    while (typeNow < maxType) {
        Column(

        ) {
            for (i in 0 until 2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (item in typeNow until minOf(typeNow + 3, maxType)) {
                        typeNow++
                        Box(
                            modifier = Modifier
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            GridItem(
                                Recipe.Diet.values()[item].value,
                                inputFilters,
                                isSelected = selectedType == item,
                                onItemSelected = {
                                    selectedType = item
                                    inputFilters.updateDiets(it)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GridItem(item: String, inputFilters: InputFilters, isSelected: Boolean, onItemSelected: (String) -> Unit) {
    var itemtext = item
    if(itemtext.isEmpty())
        itemtext = "default"
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) Color(0xff5AEFCB) else Color(0xff9eb2da))
            .clickable{
                onItemSelected(item)
            }
    )
    {
        Text(
            text = itemtext,
            modifier = Modifier.padding(10.dp)
        )
    }

}