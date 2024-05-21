package com.example.feature.players.ui.models

import com.example.common.mapping.UiModel
import com.example.common.mapping.UiToDomainMapper
import com.example.feature.players.domain.models.PlayerDomainData

data class PlayerUiData(
    val accountId: Long = 0,
    val avatar: String = " ",
    val name: String = " ",
    val lastMitchTime: String = " ",
    val similarity: String = " ",
) : UiModel, UiToDomainMapper<PlayerUiData, PlayerDomainData> {

    override fun mapToDomain(ui: PlayerUiData): PlayerDomainData {
        return PlayerDomainData(
            ui.accountId,
            ui.avatar,
            ui.name,
            ui.lastMitchTime,
            ui.similarity
        )
    }

}

fun PlayerDomainData.mapToUi() =
    PlayerUiData(
        accountId ?: 0,
        avatar ?: "",
        name ?: "",
        lastMitchTime ?: "",
        similarity ?: ""
    )