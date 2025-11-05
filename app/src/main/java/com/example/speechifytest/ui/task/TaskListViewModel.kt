package com.example.speechifytest.ui.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speechifytest.data.model.task.Task
import com.example.speechifytest.data.repository.task.ITaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    var taskRepository: ITaskRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<TaskListUIState> =
        MutableStateFlow(value = TaskListUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchAll()
    }

    fun fetchAll() {
        viewModelScope.launch {
            taskRepository.getAll()
                .onSuccess { it ->
                    _uiState.value = TaskListUIState.Success(it)
                }.onFailure {
                    _uiState.value = TaskListUIState.Failure(it.message ?: "not found")
                }
        }
    }


    fun add(task: Task) {
        viewModelScope.launch {
            taskRepository.add(task)
                .onSuccess { it ->
                    _uiState.value = TaskListUIState.Success(it)
                }.onFailure {
                    _uiState.value = TaskListUIState.Failure(it.message ?: "no message found")
                }
        }
    }

    fun delete(task: Task) {
        viewModelScope.launch {
            taskRepository.delete(task)
                .onSuccess {
                    _uiState.value = TaskListUIState.Success(it)
                }.onFailure {
                    _uiState.value = TaskListUIState.Failure(it.message ?: "")
                }
        }
    }

}