package com.example.abobusteam.screens.dishRecipe

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abobusteam.LocalNavController

@Composable
fun TopBar(){
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        val navController = LocalNavController.current
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
                    .size(32.dp)
                    .clickable{
                        navController?.navigateUp()
                    },
            )
        }

        Text(
            text = "Back", //заменить на категрию?
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        var favIconStyle by remember { mutableStateOf(Icons.Default.FavoriteBorder) }
        IconButton(
            onClick = {
                if (favIconStyle == Icons.Default.FavoriteBorder)
                    favIconStyle = Icons.Default.Favorite
                else
                    favIconStyle = Icons.Default.FavoriteBorder
            }) {
            Icon(
                imageVector = favIconStyle,
                contentDescription = "Back Button",
                tint = Color(0xFFFF98AA),
                modifier = Modifier
                    .size(38.dp),
            )
        }
    }
}