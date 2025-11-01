package com.example.speechifytest.data.model

import java.util.UUID

data class Expense(
    val id: String = UUID.randomUUID().toString(),
    val amount: Double,
    val category: ExpenseCategory,
    val description: String = "",
    val date: Long = System.currentTimeMillis(), // Unix timestamp
    val createdAt: Long = System.currentTimeMillis()
)
