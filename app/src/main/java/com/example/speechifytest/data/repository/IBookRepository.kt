package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Book

interface IBookRepository {

    suspend fun getAllBooks(): Result<List<Book>>
    suspend fun getSpecificBook(id: String): Result<Book>

}