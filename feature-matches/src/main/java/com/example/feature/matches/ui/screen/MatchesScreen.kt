package com.example.feature.matches.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.feature.matches.ui.MatchItem
import com.example.feature.matches.ui.models.MatchUiData

@Composable
fun MatchesScreen(viewModel: MatchesScreenViewModel, nextStep: () -> Unit) {

    val state = viewModel.state.collectAsState()
    val lazyColumnState = remember { LazyListState() }
    val switchState = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Switch(checked = switchState.value, onCheckedChange = {
                switchState.value = !switchState.value
                Log.d("bugger", "switchState.value ${switchState.value}")
            })
            LazyColumn(modifier = Modifier.weight(1f), lazyColumnState) {
                items(sortB8Matches(state.value.list, switchState.value)) {
                    MatchItem(it)
                }
            }
        }
    }
}

fun sortB8Matches(list: List<MatchUiData>, switchState: Boolean): List<MatchUiData> {
    return if (!switchState) list else list.filter {
        it.radiantName.contains("b8", true) || it.direName.contains("b8", true)
    }
}