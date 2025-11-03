package com.example.speechifytest.data.repository.note

import com.example.speechifytest.data.model.note.Note

interface INoteRepository {
    suspend fun getAll(): Result<List<Note>>
    suspend fun delete(note: Note): Result<List<Note>>
    suspend fun add(note: Note): Result<List<Note>>

}