package com.example.speechifytest.ui.booklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.speechifytest.data.model.Book

@Composable
fun UserListScreen(onClick:()->Unit) {

    var bookList = mutableListOf<Book>(
        Book("1","1"),
        Book("1","1"),
        Book("1","1"),
        Book("1","1"),
        Book("1","1")

    )
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn {
            bookList.forEachIndexed { index, book ->
                item(key = index){
                    
                }
            }
        }
    }
}

@Preview
@Composable
private fun UserListScreenPreview() {
    UserListScreen(onClick = {})
}