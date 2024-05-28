package com.itsumaircode.displayuserdata.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.itsumaircode.displayuserdata.R
import com.itsumaircode.displayuserdata.models.UserDataModel

@Composable
fun UserDataListItem(
    userDataModel: UserDataModel,
    onClick: (userDataModel: UserDataModel) -> Unit
) {
    Card(
        // To give elevation to card
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        // To make the card corners round
        shape = RoundedCornerShape(10.dp),
        // To give padding to card
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(userDataModel) }
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.my_img),
                contentDescription = "Profile Pic",
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Black)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Text(
                    text = userDataModel.userName,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp)
                )
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth(.7f)
                        .height(1.dp)
                )
                Text(
                    text = userDataModel.userEmail,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp),
                    fontWeight = FontWeight.Thin
                )
            }

        }
    }
}