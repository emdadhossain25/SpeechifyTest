package com.example.speechifytest.ui.note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun NoteListScreen(
    onSubmit: () -> Unit
//    later will add viewmodel
) {

    var name by mutableStateOf("")
    var email by mutableStateOf("")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {


            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                isError = name.isEmpty(),
                placeholder = { Text(text = "Name") },
                label = { Text("Name") }
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                isError = email.isEmpty(),
                placeholder = { Text(text = "Email") },
                label = { Text("Email") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onSubmit,
                enabled = true,
                modifier = Modifier.fillMaxWidth(.5f)

            ) {
                Text("Submit")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteListScreenPrev() {
    NoteListScreen(
        onSubmit = {}
    )
}