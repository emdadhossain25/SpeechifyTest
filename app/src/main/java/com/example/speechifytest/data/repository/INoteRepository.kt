package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Note

interface INoteRepository {
    suspend fun fetchAll(): Result<List<Note>>
    suspend fun delete(note: Note): Result<List<Note>>
    suspend fun add(note: Note): Result<List<Note>>
}