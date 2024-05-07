package com.example.feature.main.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.main.domain.FetchListPlayersFromCloudUseCase
import com.foe.common.api.utils.getResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val fetchListPlayersFromCloudUseCase: FetchListPlayersFromCloudUseCase) :
    ViewModel() {

    init {
        viewModelScope.launch {
            fetchListPlayersFromCloudUseCase.getPlayers("").collect {
                it.getResult(
                    success = {

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