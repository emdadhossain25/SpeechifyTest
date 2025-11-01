package com.example.speechifytest.ui.addexpense

import androidx.lifecycle.ViewModel
import com.example.speechifytest.data.repository.IExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    val expenseRepository: IExpenseRepository
): ViewModel() {


}