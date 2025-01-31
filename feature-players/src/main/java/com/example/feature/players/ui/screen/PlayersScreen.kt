package com.example.feature.players.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature.players.ui.item.PlayerItem
import com.example.feature.players.ui.item.PlayerShimmerItem
import com.example.feature.players.ui.models.PlayerUiData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun PlayersScreen(
    viewModel: PlayersScreenViewModel = hiltViewModel(),
    navigateToProfile: (Long, String) -> Unit,
) {

    PlayersScreenUI(
        viewModel.state.collectAsState(),
        remember { viewModel::onEvent },
        navigateToProfile,
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreenUI(
    state: State<PlayersScreenState>,
    onEvent: (PlayersScreenIntent) -> Unit,
    navigateToProfile: (Long, String) -> Unit,
) {

    var searchFieldValue by rememberSaveable { mutableStateOf("") }
    val lazyColumnState = rememberLazyListState()
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val onClickItem: (Long, String) -> Unit = remember {
        { id, name ->
            focusManager.clearFocus()
            navigateToProfile(id, name)
        }
    }
    val pullRefreshState = rememberPullToRefreshState()
    val hapticFeedback = LocalHapticFeedback.current
    val cardOffset by animateIntAsState(
        targetValue = when {
            pullRefreshState.isRefreshing -> 250
            pullRefreshState.progress in 0f..1f -> (100 * pullRefreshState.progress).roundToInt()
            pullRefreshState.progress > 1f -> (250 + ((pullRefreshState.progress - 1f) * .1f) * 100).roundToInt()
            else -> 0
        }, label = "cardOffset"
    )

    val cardRotation by animateFloatAsState(
        targetValue = when {
            pullRefreshState.isRefreshing || pullRefreshState.progress > 1f -> 5f
            pullRefreshState.progress > 0f -> 5 * pullRefreshState.progress
            else -> 0f
        }, label = "cardRotation"
    )
    LaunchedEffect(Unit) {
        if (searchFieldValue.isBlank())
            focusRequester.requestFocus()
    }

    LaunchedEffect(pullRefreshState.isRefreshing) {
        if (pullRefreshState.isRefreshing) {
            onEvent(PlayersScreenIntent.OnRefresh(searchFieldValue))
            hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            delay(70)
            hapticFeedback.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            delay(100)
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
        }
        if (!pullRefreshState.isRefreshing && pullRefreshState.progress > 0f) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    LaunchedEffect(state.value.isRefresh) {
        if (!state.value.isRefresh)
            pullRefreshState.endRefresh()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(pullRefreshState.nestedScrollConnection)
    ) {
        Column(Modifier.fillMaxSize()) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .focusRequester(focusRequester),
                value = searchFieldValue,
                onValueChange = {
                    searchFieldValue = it
                    onEvent(PlayersScreenIntent.OnSearchFieldValueChanged(it))
                }, label = { Text("Введите имя игрока") }
            )
            if (state.value.isLoading) {
                LazyColumn(modifier = Modifier.weight(1f), lazyColumnState) {
                    items(fakeList()) {
                        PlayerShimmerItem()
                    }
                }
            } else {
                Log.d("bugger", "${state.value.list}")
                List(
                    Modifier.weight(1f),
                    lazyColumnState,
                    state.value.list,
                    cardRotation,
                    cardOffset,
                    onClickItem
                )
            }
            if (pullRefreshState.isRefreshing) {
                PullToRefreshContainer(state = pullRefreshState)
            }
        }
        PullToRefreshContainer(
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
        )
    }
}

@Composable
fun List(
    modifier: Modifier,
    lazyColumnState: LazyListState,
    list: ImmutableList<PlayerUiData>,
    cardRotation: Float,
    cardOffset: Int,
    onClickItem: (Long, String) -> Unit
) {
    LazyColumn(modifier, lazyColumnState) {
        itemsIndexed(list) { index, item ->
            PlayerItem(
                Modifier
                    .zIndex((list.size - index).toFloat())
                    .graphicsLayer {
                        rotationZ = cardRotation * if (index % 2 == 0) 1 else -1
                        translationY = (cardOffset * ((5f - (index + 1)) / 30f)).dp
                            .roundToPx()
                            .toFloat()
                    },
                item, onClickItem
            )
        }
    }
}

private fun fakeList(): List<Unit> {
    return mutableListOf<Unit>().apply {
        repeat(10) {
            add(Unit)
        }
    }.toList()
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun PlayersScreenPreview() {
    val state = mutableStateOf(PlayersScreenState())
    PlayersScreenUI(state, {}, { _, _ -> })
}