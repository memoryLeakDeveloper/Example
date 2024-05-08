package com.example.feature.players.ui.models

import com.example.feature.players.domain.models.PlayerDomainData

data class PlayerUiData(
    val accountId: Long = 0,
    val avatar: String = " ",
    val name: String = " ",
    val lastMitchTime: String = " ",
    val similarity: String = " ",
)

fun PlayerDomainData.mapToUi() =
    PlayerUiData(accountId ?: 0, avatar ?: "", name ?: "", lastMitchTime ?: "", similarity ?: "")
