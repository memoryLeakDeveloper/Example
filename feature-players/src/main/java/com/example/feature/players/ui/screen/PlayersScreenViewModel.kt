package com.example.feature.players.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.players.domain.usecase.FetchListPlayersFromCloudUseCase
import com.example.feature.players.ui.models.mapToUi
import com.foe.common.api.utils.getResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersScreenViewModel @Inject constructor(private val fetchListPlayersFromCloudUseCase: FetchListPlayersFromCloudUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(PlayersScreenState())
    val state = _state.asStateFlow()

    private var job: Job? = null

    fun onEvent(intent: PlayersScreenIntent) {
        when (intent) {
            is PlayersScreenIntent.OnSearchFieldValueChanged -> {
                fetchListPlayersByQuery(intent.value, false)
            }

            is PlayersScreenIntent.OnRefresh -> {
                fetchListPlayersByQuery(intent.value, true)
            }
        }
    }

    private fun fetchListPlayersByQuery(query: String, isRefresh: Boolean) {
        job?.cancel()
        if (query.trim().length < 3) {
            _state.update {
                it.copy(list = emptyList(), isLoading = false, isRefresh = false)
            }
            return
        }
        job = viewModelScope.launch {
            fetchListPlayersFromCloudUseCase.getPlayers(query).collect {
                it.getResult(
                    success = {
                        val result = it.result.map { it.mapToUi() }
                        Log.d("bugger", "size = ${result.size}")
                        _state.update {
                            it.copy(list = result, isLoading = false, isRefresh = false)
                        }
                    },
                    loading = {
                        _state.update {
                            if (isRefresh)
                                it.copy(isRefresh = true)
                            else
                                it.copy(isLoading = true)
                        }
                    },
                    failure = {

                    }
                )
            }
        }
    }


}