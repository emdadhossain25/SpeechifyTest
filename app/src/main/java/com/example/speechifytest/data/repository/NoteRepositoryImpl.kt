package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImpl @Inject constructor() : INoteRepository {
    var noteList = mutableListOf<Note>()
    override suspend fun fetchAll(): Result<List<Note>> {
        try {
            return Result.success(noteList)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun delete(note: Note): Result<List<Note>> {
        try {
            noteList.remove(note)
            return Result.success(noteList)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun add(note: Note): Result<List<Note>> {
        try {
            noteList.add(note)
            return Result.success(noteList)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}