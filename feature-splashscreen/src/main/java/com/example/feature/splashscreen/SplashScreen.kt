package com.example.feature.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigate: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(2_000)
        navigate()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(modifier = Modifier, painter = painterResource(id = R.drawable.dota_logo), contentDescription = null)
    }

}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen {}
}