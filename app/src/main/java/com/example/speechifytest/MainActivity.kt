package com.example.speechifytest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.speechifytest.presentation.FirstComposableScreen
import com.example.speechifytest.ui.theme.SpeechifyTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpeechifyTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    // TODO add a composable here
                    FirstComposableScreen()

                }
            }
        }
    }
}
