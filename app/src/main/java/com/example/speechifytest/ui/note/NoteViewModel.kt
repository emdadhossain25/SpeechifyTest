package com.example.speechifytest.ui.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speechifytest.data.model.note.Note
import com.example.speechifytest.data.repository.note.INoteRepository
import com.example.speechifytest.data.repository.task.ITaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
//   repository will be added
    private val noteRepository: INoteRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<NoteUIState>(NoteUIState.Loading)
    val uiState = _uiState.asStateFlow()


    init {
        fetchAll()
    }

    fun fetchAll() {
        viewModelScope.launch {
            noteRepository.getAll().onSuccess {
                _uiState.value = NoteUIState.Success(it)
            }.onFailure {
                _uiState.value = NoteUIState.Failure(it.message ?: "not any message got failed")
            }
        }
    }


    fun add(note: Note) {
        viewModelScope.launch {

            noteRepository.add(note).onSuccess {
                _uiState.value = NoteUIState.Success(it)
            }.onFailure {
                _uiState.value = NoteUIState.Failure(it.message ?: "")
            }
        }
    }


    fun remove(note: Note) {
        viewModelScope.launch {
            noteRepository.delete(note).onSuccess {
                _uiState.value = NoteUIState.Success(it)
            }.onFailure {
                _uiState.value = NoteUIState.Failure(it.message ?: "no error message but failed")
            }

        }
    }
}