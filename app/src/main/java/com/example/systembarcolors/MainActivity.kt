package com.example.systembarcolors

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.systembarcolors.ui.theme.Pink40
import com.example.systembarcolors.ui.theme.SystemBarColorsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SystemBarColorsTheme {
                // A surface container using the 'background' color from the theme
                val systemUiController = rememberSystemUiController()
                val DarkTheam = isSystemInDarkTheme()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = if(DarkTheam) Color.LightGray else Pink40
                    )
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SystemBarColorsTheme {
            Greeting("Android")
        }
    }
}