package com.example.feature.player.profile.domain.models

data class PlayerProfileDomainData(
    val soloCompetitiveRank: Long = 0,
    val competitiveRank: Long = 0,
    val rankTier: Long = 0,
    val leaderboardRank: Long = 0,
    val profile: PlayerInfoDomainData = PlayerInfoDomainData(),
)