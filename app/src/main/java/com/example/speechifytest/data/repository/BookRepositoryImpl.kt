package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Book

class BookRepositoryImpl: IBookRepository{
    override suspend fun getAllBooks(): Result<List<Book>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpecificBook(id: String): Result<Book> {
        TODO("Not yet implemented")
    }
}