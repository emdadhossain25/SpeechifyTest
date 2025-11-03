package com.example.speechifytest.data.repository.note

import com.example.speechifytest.data.model.note.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImpl @Inject constructor() : INoteRepository {
    val noteList = mutableListOf<Note>()
    override suspend fun getAll(): Result<List<Note>> {
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