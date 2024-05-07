package com.example.feature.main.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(nextStep: () -> Unit) {

    Column {
        Button(modifier = Modifier.size(100.dp), onClick = { nextStep() }) {
            Text(text = "hi")

        }
    }


}