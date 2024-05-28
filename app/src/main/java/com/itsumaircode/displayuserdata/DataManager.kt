package com.itsumaircode.displayuserdata

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.itsumaircode.displayuserdata.models.UserDataModel

object DataManager {

    var userData = emptyArray<UserDataModel>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LIST)
    var currentUserData: UserDataModel? = null

    fun customUserData() {
        // Add multiple UserDataModel objects
        val users = listOf(
            UserDataModel("oyeumair9@gmail.com", "1", "Umair Rasheed"),
            UserDataModel("umairrasheed89@gmail.com", "1", "Muhammad Umair")
        )
        userData += users.toTypedArray()
        isDataLoaded.value = true
    }

    fun loadAssestsFromFile(context: Context) {
        val inputStrem = context.assets.open("userdata.json")
        val size: Int = inputStrem.available()
        val buffer = ByteArray(size)
        inputStrem.read(buffer)
        inputStrem.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        userData = gson.fromJson(json, Array<UserDataModel>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(currentUserDataModel: UserDataModel?) {
        if (currentPage.value == Pages.LIST) {
            currentUserData = currentUserDataModel
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LIST
        }
    }

}