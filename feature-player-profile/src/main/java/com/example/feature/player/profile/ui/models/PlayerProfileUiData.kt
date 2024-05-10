package com.example.feature.player.profile.ui.models

import com.example.feature.player.profile.domain.models.PlayerProfileDomainData

data class PlayerProfileUiData(
    val soloCompetitiveRank: Long? = 0,
    val competitiveRank: Long? = 0,
    val rankTier: Long? = 0,
    val leaderboardRank: Long? = 0,
    val profile: PlayerInfoUiData? = null,
)

fun PlayerProfileDomainData.mapToUi() =
    PlayerProfileUiData(
        soloCompetitiveRank,
        competitiveRank,
        rankTier,
        leaderboardRank,
        profile.mapToUi()
    )
