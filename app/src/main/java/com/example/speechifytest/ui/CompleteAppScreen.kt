package com.example.speechifytest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun CompleteAppScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("dialogs", "Sheet", "Controls")
    Column(modifier = Modifier.fillMaxSize()) {
//        TabRow(
//            selectedTabIndex = selectedTab
//        ) {
//            tabs.forEachIndexed{ index,title->
//                Tab(
//                    selected = selectedTab == index,
//                    onClick = {selectedTab= index},
//                    text = {Text(title)}
//                )
//            }
//
//        }
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        when (selectedTab) {
            0 -> DialogScreen()
//            1 -> SheetsScreen()
//            2 -> ControlsScreen()

        }
    }
}