package com.example.speechifytest.ui.notelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speechifytest.data.repository.INoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    val repository: INoteRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<NoteListUIState> =
        MutableStateFlow(NoteListUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {

        getAllNotes()
    }

    fun getAllNotes() {

        viewModelScope.launch {
            repository.fetchAll().onSuccess {
                _uiState.value = NoteListUIState.Success(it)
            }.onFailure {
                _uiState.value = NoteListUIState.Failure(it.message ?: "error not found")
            }
        }
    }


}