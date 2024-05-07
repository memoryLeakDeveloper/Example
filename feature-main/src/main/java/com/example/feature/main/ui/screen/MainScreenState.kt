package com.example.feature.main.ui.screen

import com.example.common.ui.BaseScreenState
import com.example.feature.main.ui.PlayerUiData

data class MainScreenState(
    val list: List<PlayerUiData> = emptyList(),
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    override val error: Throwable? = null
) : BaseScreenState(isLoading, isError, error)
