package com.example.speechifytest.data.repository

import android.content.Context
import com.example.speechifytest.data.model.Book
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context
) : IBookRepository {
    override suspend fun getAllBooks(): Result<List<Book>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpecificBook(id: String): Result<Book> {
        TODO("Not yet implemented")
    }
}