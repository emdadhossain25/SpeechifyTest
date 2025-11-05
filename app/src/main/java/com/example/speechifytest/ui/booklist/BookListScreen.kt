package com.example.speechifytest.ui.booklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.speechifytest.data.model.Book
import com.example.speechifytest.ui.booklist.component.BookItemCard

@Composable
fun UserListScreen(onClickButton: () -> Unit) {

    var bookList = mutableListOf<Book>(
        Book("1", "1"),
        Book("1", "1"),
        Book("1", "1"),
        Book("1", "1"),
        Book("1", "1")

    )
    Column {
        Box(modifier = Modifier.wrapContentHeight()) {
            LazyColumn {
                bookList.forEachIndexed { index, book ->
                    item(key = index) {
                        BookItemCard(book.title, book.author)
                    }
                }
            }

        }
        Button(
            modifier = Modifier.fillMaxWidth(0.5f),
            onClick = onClickButton
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserListScreenPreview() {
    UserListScreen(onClickButton = {})
}