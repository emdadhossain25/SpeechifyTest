package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepositoryImpl @Inject constructor() : IItemRespository {

    var itemList = mutableListOf<Item>()

    override suspend fun add(item: Item): Result<Unit> {
        try {
            itemList.add(item)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getAll(): Result<List<Item>> {
        try {
            return Result.success(itemList)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun delete(item: Item): Result<Unit> {
        try {
            itemList.remove(item)
            return Result.success(Unit)

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}