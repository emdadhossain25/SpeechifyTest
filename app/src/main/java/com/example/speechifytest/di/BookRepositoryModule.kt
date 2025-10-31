package com.example.speechifytest.di

import com.example.speechifytest.data.repository.BookRepositoryImpl
import com.example.speechifytest.data.repository.IBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BookRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBookRepository(bookRepositoryImpl: BookRepositoryImpl): IBookRepository
}