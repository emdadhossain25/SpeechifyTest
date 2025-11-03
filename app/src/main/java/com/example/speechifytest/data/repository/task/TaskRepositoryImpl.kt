package com.example.speechifytest.data.repository.task

import com.example.speechifytest.data.model.task.Task
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor() : ITaskRepository {
    val taskList = mutableListOf<Task>()
    override suspend fun getAll(): Result<List<Task>> {
        try {
            return Result.success(taskList)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun delete(task: Task): Result<Unit> {
        try {
            taskList.remove(task)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun add(task: Task): Result<Unit> {
        try {
            taskList.add(task)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}