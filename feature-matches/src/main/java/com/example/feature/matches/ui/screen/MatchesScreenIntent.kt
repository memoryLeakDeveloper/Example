package com.example.feature.matches.ui.screen

sealed interface MatchesScreenIntent {

     class OnSwitchStateChanged(val state: Boolean): MatchesScreenIntent
}