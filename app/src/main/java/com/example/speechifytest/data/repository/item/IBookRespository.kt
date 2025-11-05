package com.example.speechifytest.data.repository.item

import com.example.speechifytest.data.model.Book
import com.example.speechifytest.data.model.item.Item

interface IBookRespository {
    suspend fun add(book: Book): Result<Unit>
    suspend fun getAll(): Result<List<Book>>
    suspend fun delete(book: Book): Result<Unit>
}