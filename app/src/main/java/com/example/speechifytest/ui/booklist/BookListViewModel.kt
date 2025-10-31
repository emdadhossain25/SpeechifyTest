package com.example.speechifytest.ui.booklist

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.speechifytest.data.repository.IBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    val iBookRepository: IBookRepository
) : ViewModel() {

    private val _bookListUiState: MutableStateFlow<BookListUIState> =
        MutableStateFlow(value = BookListUIState.isLoading)

    val bookListUIState = _bookListUiState.asStateFlow()

}