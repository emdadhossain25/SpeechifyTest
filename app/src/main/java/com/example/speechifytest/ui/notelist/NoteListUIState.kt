package com.example.speechifytest.ui.notelist

import com.example.speechifytest.data.model.Note

sealed class NoteListUIState {
    data object Loading : NoteListUIState()
    data class Success(val data: List<Note>) : NoteListUIState()
    data class Failure(val message: String) : NoteListUIState()
}