package com.example.speechifytest.ui.expenselist

import com.example.speechifytest.data.model.Expense

sealed class ExpenseListState {
    data object Loading : ExpenseListState()
    data class Success(val expenseList: List<Expense>) : ExpenseListState()
    data class Failure(val e: Exception) : ExpenseListState()
}