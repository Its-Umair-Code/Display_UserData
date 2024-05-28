package com.itsumaircode.displayuserdata.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.itsumaircode.displayuserdata.models.UserDataModel

@Composable
fun UserDataListScreen(
    data: Array<UserDataModel>,
    onClick: (userDataModel: UserDataModel) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (data.isNotEmpty()) {
            Text(
                text = "RCCC Users\' Data",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp, 15.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            UserDataList(data = data, onClick)
        }
    }
}