package com.example.abobusteam.screens.homePage

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetupActuals() {

    Text(
        text = "Актуальное",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(start = 16.dp, top = 24.dp)
    )

    val stepsActual: List<String> = listOf(
        "Картофельное пюре",
        "Доступный ЗОЖ",
        "Десерт от Гордона Рамзи",
        "Санечковый пуддинг",
        "Филе де Лизюргерс"
    )

    LazyRow {
        itemsIndexed(stepsActual) { _: Int, item ->
            StepsActual(item)
        }
    }
}

@Composable
fun StepsActual(actuals: String) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(12.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                //.padding(10.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(Color(0xFFeef4f8))
                .clickable {
                    Toast
                        .makeText(context, actuals, Toast.LENGTH_SHORT)
                        .show()
                }
        ) {
            Text(
                text = actuals,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}