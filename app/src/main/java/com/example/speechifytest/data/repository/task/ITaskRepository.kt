package com.example.speechifytest.data.repository.task

import com.example.speechifytest.data.model.task.Task

interface ITaskRepository {
    suspend fun getAll():Result<List<Task>>
    suspend fun delete(task:Task):Result<Unit>
    suspend fun add(task:Task):Result<Unit>
}
