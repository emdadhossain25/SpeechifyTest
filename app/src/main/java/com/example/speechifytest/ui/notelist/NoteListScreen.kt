package com.example.speechifytest.ui.notelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NoteListScreen(
    onSubmit: () -> Unit,
    noteListViewModel: NoteListViewModel,
) {

    val uiState = noteListViewModel.uiState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (uiState.value) {
                    is NoteListUIState.Failure -> TODO()
                    NoteListUIState.Loading -> TODO()
                    is NoteListUIState.Success -> TODO()
                }
            }
        }
    }

}