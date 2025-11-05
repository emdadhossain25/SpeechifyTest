package com.example.speechifytest.ui.booklist

import androidx.compose.material3.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speechifytest.data.model.Book
import com.example.speechifytest.data.model.task.Task
import com.example.speechifytest.data.repository.item.IBookRespository
import com.example.speechifytest.ui.task.TaskListUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    val bookRepository: IBookRespository
) : ViewModel() {
    private val _uiState: MutableStateFlow<BookListUIState> =
        MutableStateFlow(BookListUIState.Loading)

    val uiState = _uiState.asStateFlow()

    init {

        fetchAll()
    }

    fun fetchAll() {
        viewModelScope.launch {
            bookRepository.getAll().onSuccess {
                _uiState.value = BookListUIState.Success(it)
            }.onFailure {
                _uiState.value = BookListUIState.Failure(it.message ?: "Not found")
            }
        }
    }

    fun add(book: Book) {

        viewModelScope.launch {
            bookRepository.add(book).onSuccess {
                _uiState.value = BookListUIState.Success(it)
            }.onFailure {
                _uiState.value = BookListUIState.Failure(it.message ?: "could not add")
            }
        }
    }


    fun delete(book: Book) {
        viewModelScope.launch {
            bookRepository.delete(book).onSuccess {
                _uiState.value = BookListUIState.Success(it)
            }.onFailure {
                _uiState.value = BookListUIState.Failure(it.message ?: "could not delete")
            }
        }
    }


}


















