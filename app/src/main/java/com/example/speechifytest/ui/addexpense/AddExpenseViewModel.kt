package com.example.speechifytest.ui.addexpense

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speechifytest.data.model.Expense
import com.example.speechifytest.data.repository.IExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val expenseRepository: IExpenseRepository
) : ViewModel() {

    private val _addExpenseState: MutableStateFlow<AddExpenseState> =
        MutableStateFlow(AddExpenseState.Loading)
    val addExpenseState = _addExpenseState.asStateFlow()

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseRepository.addExpense(expense = expense).onSuccess {
                _addExpenseState.value = AddExpenseState.Success(expense)
            }.onFailure { e ->
                _addExpenseState.value = AddExpenseState.Failure(e.message ?: "")
            }

        }
    }

}