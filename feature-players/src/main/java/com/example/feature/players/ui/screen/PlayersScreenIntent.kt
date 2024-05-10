package com.example.feature.players.ui.screen

sealed interface PlayersScreenIntent {

    class OnRefresh(val value: String) : PlayersScreenIntent

    class OnSearchFieldValueChanged(val value: String) : PlayersScreenIntent
}