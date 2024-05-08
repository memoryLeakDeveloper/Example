package com.example.feature.players.ui.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.feature.players.R
import com.example.feature.players.ui.models.PlayerUiData

@Composable
fun PlayerItem(item: PlayerUiData, onClick: (Long) -> Unit) {
    Surface(
        modifier = Modifier
            .padding(top = 8.dp, start = 10.dp, end = 10.dp)
            .clickable { onClick(item.accountId) },
        shadowElevation = 9.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.avatar,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.placeholder_person),
                error = painterResource(id = R.drawable.placeholder_person),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = item.name)
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
private fun PlayerItemPreview() {
    val item = PlayerUiData(name = "1111", lastMitchTime = "2019-11-15T17:45:39.000Z")
    PlayerItem(item, {})
}