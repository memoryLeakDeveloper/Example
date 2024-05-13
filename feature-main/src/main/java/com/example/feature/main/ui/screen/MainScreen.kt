package com.example.feature.main.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
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
import com.example.common.navigation.Screens

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    navigateTo: (Screens) -> Unit,
) {

    MainScreenUI(viewModel.state.collectAsState(), navigateTo)

}

@Composable
fun MainScreenUI(
    state: State<MainScreenState>,
    navigateTo: (Screens) -> Unit,
) {

    Column(modifier = Modifier.padding(10.dp)) {
        Button(
            modifier = Modifier
                .wrapContentWidth()
                .height(50.dp),
            onClick = { navigateTo(Screens.Players) }) {
            Text(text = "Players")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .wrapContentWidth()
                .height(50.dp),
            onClick = { navigateTo(Screens.Matches) }) {
            Text(text = "Matches")
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    val state = remember { mutableStateOf(MainScreenState()) }
    MainScreenUI(state, {})
}