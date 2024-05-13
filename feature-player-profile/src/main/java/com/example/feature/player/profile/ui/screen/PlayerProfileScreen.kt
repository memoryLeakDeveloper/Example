package com.example.feature.player.profile.ui.screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.feature.player.profile.R

@Composable
fun PlayerProfileScreen(
    accountId: Long = 0,
    accountName: String = "",
    viewModel: PlayerProfileScreenViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
) {

    PlayerProfileScreenUI(
        accountId,
        accountName,
        viewModel::onEvent,
        viewModel.state.collectAsState(),
        onBackPressed
    )

}

@Composable
fun PlayerProfileScreenUI(
    accountId: Long = 0,
    accountName: String = "",
    onEvent: (PlayerProfileScreenIntent) -> Unit,
    state: State<PlayerProfileScreenState>,
    onBackPressed: () -> Unit,
) {

    BackHandler {
        onBackPressed()
    }

    LaunchedEffect(key1 = null, block = {
        onEvent(PlayerProfileScreenIntent.OnLoadProfile(accountId))
    })

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            AsyncImage(
                model = state.value.profile?.profile?.avatarFull,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.placeholder_person),
                error = painterResource(id = R.drawable.placeholder_person),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Log.d("bugger", "PlayerItem ${accountName}")

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = state.value.profile?.profile?.personaName ?: "")
        }
    }
}

@Preview
@Composable
fun PlayerProfileScreenPreview() {
    val state = mutableStateOf(PlayerProfileScreenState())
    PlayerProfileScreenUI(0, "", {}, state, {})
}