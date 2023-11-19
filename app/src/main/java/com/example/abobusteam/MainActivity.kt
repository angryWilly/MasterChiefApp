package com.example.abobusteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.abobusteam.ui.theme.AbobusTeamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbobusTeamTheme {
                MainScreen()

            }
        }
    }
}
