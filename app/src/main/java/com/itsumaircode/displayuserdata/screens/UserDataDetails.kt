package com.itsumaircode.displayuserdata.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsumaircode.displayuserdata.DataManager
import com.itsumaircode.displayuserdata.R
import com.itsumaircode.displayuserdata.models.UserDataModel

@Composable
fun UserDataDetail(userDataModel: UserDataModel) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.Gray,
                        Color.Cyan
                    )
                )
            )
    ) {
        Card(
            // To give elevation to card
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            // To make the card corners round
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.my_img),
                    contentDescription = "Profile Pic",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black)
                )
                Text(
                    text = userDataModel.userName,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
                )
                Text(
                    text = userDataModel.userEmail,
                    modifier = Modifier.padding(0.dp, 3.dp, 0.dp, 0.dp),
                    fontSize = 12.sp
                )
            }
        }
    }
}