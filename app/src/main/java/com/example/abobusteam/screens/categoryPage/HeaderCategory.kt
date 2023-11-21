package com.example.abobusteam.screens.categoryPage

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.screens.homePage.StepsActual

@Composable
fun SetupHeader() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = {
                    Toast
                        .makeText(context, "Test", Toast.LENGTH_SHORT)
                        .show()
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .size(32.dp),
                )
            }
            Text(
                text = "Все рецепты",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 46.dp)
            )
        }
    }

    Row(
        modifier = Modifier
            .padding(start = 10.dp)
            .fillMaxWidth()
    ){
        Text(
            text = "Выпечка",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 14.dp)
        )
    }

    val stepsHeader: List<String> = listOf(
        "До часа",
        "200 - 400 ккал",
        "Выпечка",
        "Диетическое"
    )

    LazyRow {
        itemsIndexed(stepsHeader) { _: Int, item ->
            StepsActual(item)
        }
    }

}

