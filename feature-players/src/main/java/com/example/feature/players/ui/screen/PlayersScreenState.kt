package com.example.feature.players.ui.screen

import com.example.common.ui.BaseScreenState
import com.example.feature.players.ui.models.PlayerUiData

data class PlayersScreenState(
    val list: List<PlayerUiData> = emptyList(),
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    override val error: Throwable? = null
) : BaseScreenState(isLoading, isError, error)
