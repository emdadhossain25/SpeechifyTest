package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Expense
import kotlinx.coroutines.flow.Flow

interface IExpenseRepository {

    suspend fun addExpense(expense: Expense): Result<Unit>
    suspend fun getAllExpenses(): Result<List<Expense>>
//    fun getExpensesFlow(): Flow<Expense>
}