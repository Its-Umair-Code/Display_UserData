package com.itsumaircode.displayuserdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.itsumaircode.displayuserdata.screens.UserDataDetail
import com.itsumaircode.displayuserdata.screens.UserDataListScreen
import com.itsumaircode.displayuserdata.ui.theme.DisplayUserDataTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // To call this on background IO thread not on Main UI thread
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadAssestsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LIST) {
            UserDataListScreen(data = DataManager.userData) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentUserData?.let { UserDataDetail(userDataModel = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

enum class Pages {
    LIST,
    DETAIL
}