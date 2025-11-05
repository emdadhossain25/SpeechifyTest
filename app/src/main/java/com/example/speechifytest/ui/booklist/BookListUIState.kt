package com.example.speechifytest.ui.booklist

sealed class BookListUIState {
    data object Loading : BookListUIState()
    data class Success(var data: Any) : BookListUIState()
    data class Failure(var message: String) : BookListUIState()
}