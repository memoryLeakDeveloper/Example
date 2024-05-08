package com.example.feature.players.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.players.domain.usecase.FetchListPlayersFromCloudUseCase
import com.example.feature.players.ui.models.mapToUi
import com.foe.common.api.utils.getResult
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun onEvent(intent: PlayersScreenIntent) {
        when (intent) {
            is PlayersScreenIntent.OnSearchFieldValueChanged -> {
                fetchListPlayersByQuery(intent.value)
            }
        }
    }

    private fun fetchListPlayersByQuery(query: String) {
        viewModelScope.launch {
            fetchListPlayersFromCloudUseCase.getPlayers(query).collect {
                it.getResult(
                    success = {
                        val result = it.result.map { it.mapToUi() }
                        Log.d("bugger", "size = ${result.size}")
                        _state.update {
                            it.copy(list = result)
                        }
                    },
                    loading = {

                    },
                    failure = {

                    }
                )
            }
        }
    }


}