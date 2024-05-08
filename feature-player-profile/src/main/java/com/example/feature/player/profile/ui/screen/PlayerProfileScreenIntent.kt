package com.example.feature.player.profile.ui.screen

sealed interface PlayerProfileScreenIntent {

    class OnLoadProfile(val accountId: Long) : PlayerProfileScreenIntent

}