package com.example.feature.player.profile.ui.screen

import com.example.common.ui.BaseScreenState
import com.example.feature.player.profile.ui.models.PlayerProfileUiData

data class PlayerProfileScreenState(
    val profile: PlayerProfileUiData? = null,
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    override val error: Throwable? = null
) : BaseScreenState(isLoading, isError, error)
