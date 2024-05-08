package com.example.feature.matches.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.common.ui.secondsToDMY
import com.example.feature.matches.ui.models.MatchUiData

@Composable
fun MatchItem(item: MatchUiData) {
    Surface(
        modifier = Modifier.padding(vertical = 10.dp),
        shadowElevation = 9.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Blue)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = item.radiantName ?: "No name")
                Text(text = item.direName ?: "No name")
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "start time = ${item.startTime.secondsToDMY()}")
        }
    }
}

@Preview
@Composable
private fun MatchItemPreview() {
    val item = MatchUiData(radiantName = "1", direName = "2")
    MatchItem(item)
}