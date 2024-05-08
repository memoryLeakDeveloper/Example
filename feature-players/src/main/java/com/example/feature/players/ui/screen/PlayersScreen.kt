package com.example.feature.players.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature.players.ui.item.PlayerItem

@Composable
fun PlayersScreen(
    viewModel: PlayersScreenViewModel = hiltViewModel(),
    navigateToProfile: (Long) -> Unit,
) {

    PlayersScreenUI(viewModel.state.collectAsState(), viewModel::onEvent, navigateToProfile)

}

@Composable
fun PlayersScreenUI(
    state: State<PlayersScreenState>,
    onEvent: (PlayersScreenIntent) -> Unit,
    navigateToProfile: (Long) -> Unit
) {

    val lazyColumnState = remember { LazyListState() }
    val searchFieldValue = remember { mutableStateOf("") }
    val onClickItem: (Long) -> Unit = { navigateToProfile(it) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                value = searchFieldValue.value,
                onValueChange = {
                    searchFieldValue.value = it
                    onEvent(PlayersScreenIntent.OnSearchFieldValueChanged(it))
                }, label = { Text("Введите имя игрока") }
            )
            LazyColumn(modifier = Modifier.weight(1f), lazyColumnState) {
                items(state.value.list) {
                    PlayerItem(it, onClickItem)
                }
            }
        }
    }
}

@Preview
@Composable
fun PlayersScreenPreview() {
    val state = mutableStateOf(PlayersScreenState())
    PlayersScreenUI(state, {}, {})
}