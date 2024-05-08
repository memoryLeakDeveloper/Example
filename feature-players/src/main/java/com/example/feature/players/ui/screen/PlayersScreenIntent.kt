package com.example.feature.players.ui.screen

sealed interface PlayersScreenIntent {

    class OnSearchFieldValueChanged(val value: String) : PlayersScreenIntent
}