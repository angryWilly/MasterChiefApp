package com.example.abobusteam.screens.dishRecipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.Recipe
import com.example.abobusteam.RecipeInstructionStep

@Composable
fun RecipeSteps(recipe: Recipe){
    Text(
        text = "The cooking process",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(start = 24.dp, bottom = 16.dp)
    )



    var stepNum = 1
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        recipe.steps.forEach { step ->
            StepRow(step, stepNum)
            stepNum++
        }
    }

}


@Composable
fun StepRow(step: RecipeInstructionStep, stepNum: Int) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(Color(0xFF9EB2DA))
                .height(IntrinsicSize.Min)
        ) {
            Text(
                text = "Step $stepNum",
                modifier = Modifier
                    .padding(10.dp)
            )
        }

        Text(
            text = step.step,
            modifier = Modifier
                .align(Alignment.CenterVertically)
            )
    }
}
