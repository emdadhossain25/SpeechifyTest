package com.example.speechifytest.ui

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TabLayoutScreen() {
    // TODO: Create state for selectedTabIndex

    var selectedIndex by remember { mutableStateOf(0) }

    // TODO: Create list of tab titles
    val titleOfTabs = listOf(
        "Home",
        "User"
    )

    // TODO: Implement Column with:
    // - TabRow at top
    // - Content that changes based on selected tab
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedIndex,
        ) {
            titleOfTabs.forEachIndexed { index,title->
                Tab(index==selectedIndex, onClick = {selectedIndex =index},text = {Text(title)})
            }

        }

    }


}
