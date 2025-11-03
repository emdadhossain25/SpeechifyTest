package com.example.speechifytest.ui.note

import com.example.speechifytest.data.model.note.Note

sealed class NoteUIState {
    data object Loading : NoteUIState()
    data class Success(var data: List<Note>) : NoteUIState()
    data class Failure(var message: String) : NoteUIState()
}