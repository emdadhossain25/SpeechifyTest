package com.example.speechifytest.ui.addexpense

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddExpenseScreen(
    onSubmitClick: () -> Unit,
    addExpenseViewModel: AddExpenseViewModel = hiltViewModel()
) {
    val uiState = addExpenseViewModel.addExpenseState.collectAsState()

    Box {

    }
}