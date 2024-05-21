package com.example.feature.players.ui.screen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.common.ui.BaseScreenState
import com.example.feature.players.ui.models.PlayerUiData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class PlayersScreenState(
    val list: ImmutableList<PlayerUiData> = persistentListOf(),
    val isRefresh: Boolean = false,
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    @Stable override val error: Throwable? = null
) : BaseScreenState(isLoading, isError, error)
