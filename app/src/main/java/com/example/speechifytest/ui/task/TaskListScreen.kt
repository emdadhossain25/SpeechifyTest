package com.example.speechifytest.ui.task

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun TaskListScreen(
    onSubmit: () -> Unit
// will add viewModel here
) {
    var name by mutableStateOf("")
    var email by mutableStateOf("")

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                isError = name.isEmpty(),
                placeholder = { Text("Name") },
                label = { Text("Name") }
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                isError = email.isEmpty(),
                placeholder = { Text("Email") },
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(0.5f),
                onClick = onSubmit
            ) {
                Text("Submit")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun TaskListScrenPreview() {
    TaskListScreen(
        onSubmit = {}
    )
}