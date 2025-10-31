package com.example.speechifytest.ui.booklist

import com.example.speechifytest.data.model.Book

sealed class BookListUIState {
    object isLoading : BookListUIState()
    data class success(val bookList: List<Book>?) : BookListUIState()
    data class error(val message: String?) : BookListUIState()
}