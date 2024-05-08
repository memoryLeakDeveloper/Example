package com.example.feature.matches.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.matches.domain.FetchListMatchesFromCloudUseCase
import com.example.feature.matches.ui.models.mapToUi
import com.foe.common.api.utils.getResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesScreenViewModel @Inject constructor(private val fetchListMatchesFromCloudUseCase: FetchListMatchesFromCloudUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(MatchesScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            fetchListMatchesFromCloudUseCase.getMatches(0).collect {
                it.getResult(
                    success = {
                        val result = it.result.map { it.mapToUi() }
                        _state.update {
                            it.copy(list = result.sortedByDescending { it.startTime })
                        }
                    },
                    loading = {

                    },
                    failure = {
                        Log.d("bugger", it.toString())

                    }
                )
            }
        }
    }

    fun onEvent(intent: MatchesScreenIntent) {

    }


}