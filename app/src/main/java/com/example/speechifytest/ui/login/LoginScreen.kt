package com.example.speechifytest.ui.login

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun LoginScreen(onSubmitClick: () -> Unit) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedTextField(
                    placeholder = {
                        Text("Name")
                    },
                    label = {
                        Text("Name")
                    },
                    value = name,
                    onValueChange = { name = it }
                )
                OutlinedTextField(
                    placeholder = {
                        Text("Email")
                    },
                    label = {
                        Text("Email")
                    },
                    value = email,
                    onValueChange = { name = it }
                )
                Button(onClick = onSubmitClick) {
                    Text("Submit")
                }
            }


        }
    }


}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(onSubmitClick = {})
}