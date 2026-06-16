package com.timzowen.theandroidseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.timzowen.theandroidseries.navigation.AppNavigation
import com.timzowen.theandroidseries.ui.theme.TheAndroidSeriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheAndroidSeriesTheme {
                AppNavigation()
            }
        }
    }
}