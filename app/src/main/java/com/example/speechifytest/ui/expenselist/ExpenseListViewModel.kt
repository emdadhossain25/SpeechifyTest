package com.example.speechifytest.ui.expenselist

import androidx.lifecycle.ViewModel
import com.example.speechifytest.data.repository.IExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ExpenseListViewModel @Inject constructor(
    val expenseRepository: IExpenseRepository
) : ViewModel() {
}