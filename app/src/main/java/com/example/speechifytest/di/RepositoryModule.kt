package com.example.speechifytest.di

import com.example.speechifytest.data.repository.INoteRepository
import com.example.speechifytest.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepsository(repository: NoteRepositoryImpl): INoteRepository

}