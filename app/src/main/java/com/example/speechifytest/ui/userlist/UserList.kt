package com.example.speechifytest.ui.userlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.speechifytest.data.model.User

@Composable
fun UserList(
    onClick: () -> Unit
    // will have to add viewModel later
) {
//    will have to add uiSate mutableStateFlow, and collectAsState() later


    var userList = mutableListOf<User>(
        User("1", "1@email.com"),
        User("1", "1@email.com")

    )
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn {

            userList.forEachIndexed { index, user ->
                item(
                    key = index,
                    content = {
                        UserItemCard(
                            user.name,
                            user.email
                        )
                    }
                )


            }
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun UserListPreview() {
    UserList(
        onClick = {}
    )
}