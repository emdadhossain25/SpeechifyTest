package com.example.speechifytest.ui.addexpense

import com.example.speechifytest.data.model.Expense

sealed class AddExpenseState {
    data object Loading : AddExpenseState()
    data class Success(val data: Expense) : AddExpenseState()
    data class Failure(val e: Exception) : AddExpenseState()
}