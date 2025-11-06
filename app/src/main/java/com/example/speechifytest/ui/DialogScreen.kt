package com.example.speechifytest.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogScreen() {

    var snackbarHostState = remember { SnackbarHostState() }
    var showDatepicker by remember { mutableStateOf(false) }
    var showSnackBar by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    Scaffold(snackbarHost = {
        SnackbarHost(snackbarHostState)
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Button(
                onClick = { showDatepicker = true }
            ) {
                Text("Show Date Picker")
            }

            Text("Selected $selectedDate")


            Divider()

            Button(
                onClick = {
                    showSnackBar = true
//                    kotlinx.coroutines.launch {
//                    }
                }
            ) {
                Text("Show Snackbar")
            }


            Divider()

            Button(
                onClick = {
                    showDatePicker = true
                }
            ) {
                Text("Show date picker")
            }


            if (showDatepicker) {
                val datePickerState = rememberDatePickerState()
                DatePickerDialog(
                    onDismissRequest = { showDatepicker = false },
                    confirmButton = {
                        TextButton(onClick = {
                            datePickerState.selectedDateMillis?.let { millis ->
                                val formatter =
                                    SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
                                selectedDate = formatter.format(Date(millis))
                            }
                            showDatepicker = false
                        }) {
                            Text("OK")
                        }

                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showDatepicker = false }
                        ) {
                            Text("Cancel")
                        }
                    }
                ) {
                    DatePicker(
                        state = datePickerState,
                    )
                }
            }
        }

    }
}