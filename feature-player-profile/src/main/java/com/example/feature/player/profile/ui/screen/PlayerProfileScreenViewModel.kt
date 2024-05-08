package com.example.feature.player.profile.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.player.profile.domain.usecase.FetchPlayerProfileFromCloudUseCase
import com.example.feature.player.profile.ui.models.mapToUi
import com.foe.common.api.utils.getResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerProfileScreenViewModel @Inject constructor(private val fetchPlayerProfileFromCloudUseCase: FetchPlayerProfileFromCloudUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow(PlayerProfileScreenState())
    val state = _state.asStateFlow()

    fun onEvent(intent: PlayerProfileScreenIntent) {
        when (intent) {
            is PlayerProfileScreenIntent.OnLoadProfile -> {
                loadProfile(intent.accountId)
            }
        }
    }

    private fun loadProfile(accountId: Long) {
        viewModelScope.launch {
            fetchPlayerProfileFromCloudUseCase.getPlayerProfile(accountId).collect {
                it.getResult(
                    success = {
                        val result = it.result
                        Log.d("bugger", "size = ${result}")

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