package com.example.speechifytest.ui.login

import android.widget.ToggleButton
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(onSubmit: () -> Unit) {

    var isChecked1 by remember { mutableStateOf(true) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth())
            {

                Switch(
                    isChecked1,
                    onCheckedChange = { isChecked1 = it })
                Switch(
                    isChecked1,
                    onCheckedChange = { isChecked1 = it })
                Switch(
                    isChecked1,
                    onCheckedChange = { isChecked1 = it })
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview() {
    SettingsScreen(onSubmit = {})
}