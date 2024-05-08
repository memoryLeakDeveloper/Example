package com.example.feature.matches.ui.screen

import com.example.common.ui.BaseScreenState
import com.example.feature.matches.ui.models.MatchUiData

data class MatchesScreenState(
    val list: List<MatchUiData> = emptyList(),
    override val isLoading: Boolean = false,
    override val isError: Boolean = false,
    override val error: Throwable? = null
) : BaseScreenState(isLoading, isError, error)
