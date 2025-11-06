package com.example.speechifytest.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun PracticeTabRowExample(modifier: Modifier = Modifier) {

    var selectedTabIndex by remember { mutableStateOf(0) }
    var options = listOf("dialog", "bottomsheet", "control")
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            TabRow(
                selectedTabIndex = selectedTabIndex
            ) {

                options.forEachIndexed { index, title ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = { selectedTabIndex = index }
                    ) {
                        Text(title)
                    }
                }

            }

            when (selectedTabIndex) {

                0 -> DialogScreen()
                1 -> BottomSheetScreen()
                2 -> ControllerScreen()
            }
        }
    }
}