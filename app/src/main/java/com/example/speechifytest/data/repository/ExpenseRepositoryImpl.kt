package com.example.speechifytest.data.repository

import com.example.speechifytest.data.model.Expense
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepositoryImpl @Inject constructor() : IExpenseRepository {

    val expensesList: MutableList<Expense> = emptyList<Expense>() as MutableList<Expense>
    override suspend fun addExpense(expense: Expense): Result<Unit> {
        try {
            expensesList.add(expense)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getAllExpenses(): Result<List<Expense>> {
        return try {
            Result.success(expensesList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

//    override fun getExpensesFlow(): Flow<Expense>= falselow {
//        emit()
//    }
}