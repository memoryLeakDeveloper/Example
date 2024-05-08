package com.example.feature.player.profile.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common.navigation.Screens

@Composable
fun PlayerProfileScreen(
    accountId: Long = 0,
    viewModel: PlayerProfileScreenViewModel = hiltViewModel(),
    navigateTo: (Screens) -> Unit,
) {

    PlayerProfileScreenUI(
        accountId,
        viewModel::onEvent,
        viewModel.state.collectAsState(),
        navigateTo
    )

}

@Composable
fun PlayerProfileScreenUI(
    accountId: Long = 0,
    onEvent: (PlayerProfileScreenIntent) -> Unit,
    state: State<PlayerProfileScreenState>,
    navigateTo: (Screens) -> Unit
) {

    LaunchedEffect(key1 = null, block = {
        onEvent(PlayerProfileScreenIntent.OnLoadProfile(accountId))
    })

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = accountId.toString())
        }
    }
}

@Preview
@Composable
fun PlayerProfileScreenPreview() {
    val state = mutableStateOf(PlayerProfileScreenState())
    PlayerProfileScreenUI(0, {}, state, {})
}