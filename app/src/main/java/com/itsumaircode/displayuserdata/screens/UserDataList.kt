package com.itsumaircode.displayuserdata.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.itsumaircode.displayuserdata.models.UserDataModel

@Composable
fun UserDataList(data: Array<UserDataModel>, onClick: (userDataModel: UserDataModel) -> Unit) {
    LazyColumn(content = {
        items(data) {
            UserDataListItem(it, onClick)
        }
    })
}