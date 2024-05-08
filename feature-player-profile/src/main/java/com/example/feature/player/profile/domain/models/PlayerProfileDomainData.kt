package com.example.feature.player.profile.domain.models

import com.example.feature.player.profile.data.PlayerInfoData

data class PlayerProfileDomainData(
    val soloCompetitiveRank: Long = 0,
    val competitiveRank: Long = 0,
    val rankTier: Long = 0,
    val leaderboardRank: Long = 0,
    val profile: PlayerInfoData = PlayerInfoData(),
)