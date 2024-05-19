package com.example.feature.players.ui.screen

import androidx.compose.runtime.Immutable
import com.example.common.ui.BaseScreenState
import com.example.feature.players.ui.models.PlayerUiData

@Immutable
data class PlayersScreenState(
    val list: List<PlayerUiData> = emptyList(),
    val isRefresh: Boolean = false,
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    override val error: Throwable? = null
) : BaseScreenState(isLoading, isError, error)
