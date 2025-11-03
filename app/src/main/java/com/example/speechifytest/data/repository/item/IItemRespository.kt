package com.example.speechifytest.data.repository.item

import com.example.speechifytest.data.model.item.Item

interface IItemRespository {
    suspend fun add(item: Item): Result<Unit>
    suspend fun getAll(): Result<List<Item>>
    suspend fun delete(item: Item): Result<Unit>
}