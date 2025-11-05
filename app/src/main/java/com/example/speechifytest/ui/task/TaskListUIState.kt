package com.example.speechifytest.ui.task

import com.example.speechifytest.data.model.task.Task

sealed class TaskListUIState {
    data object Loading : TaskListUIState()
    data class Success(var data: Any) : TaskListUIState()
    data class Failure(var message: String) : TaskListUIState()
}