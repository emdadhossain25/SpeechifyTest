package com.example.speechifytest.ui.booklist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BookListScreen(
    bookListViewModel: BookListViewModel = hiltViewModel()
) {
    val bookUiState by bookListViewModel.bookListUIState.collectAsState()

    BookListScreenContent(
        uiState = bookUiState,
        onClick = {}
    )
}