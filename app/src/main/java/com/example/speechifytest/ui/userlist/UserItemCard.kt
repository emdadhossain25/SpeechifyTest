package com.example.speechifytest.ui.userlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speechifytest.data.model.User

@Composable
fun UserItemCard(name: String, email: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(10.dp)

        ) {
            CardItemScreen(name, email)
        }
    }
}

@Composable
fun CardItemScreen(
    name: String,
    email: String
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(2.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                "$name",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = Bold,
                fontSize = 35.sp
            )
            Text(
                "$email",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = Normal,
                fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserItemCardPreview() {

    UserItemCard("user", "email")
}