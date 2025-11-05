package com.example.speechifytest.di

import com.example.speechifytest.data.repository.item.IBookRespository
import com.example.speechifytest.data.repository.item.BookRepositoryImpl
import com.example.speechifytest.data.repository.note.INoteRepository
import com.example.speechifytest.data.repository.note.NoteRepositoryImpl
import com.example.speechifytest.data.repository.task.ITaskRepository
import com.example.speechifytest.data.repository.task.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindItemRepository(bookRepositoryImpl: BookRepositoryImpl): IBookRespository

    @Binds
    abstract fun bindTaskRepository(taskRepositoryImpl: TaskRepositoryImpl): ITaskRepository

    @Binds
    abstract fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): INoteRepository

}