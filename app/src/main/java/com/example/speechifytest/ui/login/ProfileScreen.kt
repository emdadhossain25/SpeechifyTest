package com.example.speechifytest.ui.login

import android.R
import android.content.res.Resources
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen(onSubmitClick: () -> Unit) {

    var name by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.presence_away),

                contentDescription = "start",
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .size(150.dp),
                contentScale = ContentScale.Crop,
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                placeholder = { Text("Name") },
            )
            OutlinedTextField(
                modifier = Modifier.height(260.dp),
                value = bio,
                onValueChange = { name = it },
                label = { Text("Bio") },
                placeholder = { Text("Name") },
            )
            Button(onClick = { onSubmitClick }) {
                Text("Submit")
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(onSubmitClick = {})
}