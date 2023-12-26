package com.example.abobusteam.screens.SearchScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.abobusteam.GlobalListHolder
import com.example.abobusteam.LocalNavController
import com.example.abobusteam.Request
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(){
    var value by remember {
        mutableStateOf("")
    }
    val navController = LocalNavController.current
    TextField(
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        label = { Text(text = "Find smth?") },
        placeholder = { Text(text = "") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search Icon"
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                val api = Request()
                GlobalListHolder.globalRecipeList.clear()
                GlobalListHolder.globalRecipeList = runBlocking {
                    api.getRecipes(
                        query = value,
                        count = 100)
                }
                navController?.navigate(route = "category/$value")
            }
        ),
        modifier = Modifier
            .width(400.dp)
            .padding(bottom = 20.dp)
    )
}