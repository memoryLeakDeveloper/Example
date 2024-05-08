package com.example.feature.player.profile.data

import com.example.feature.player.profile.domain.models.PlayerProfileDomainData


data class PlayerProfileData(
    val soloCompetitiveRank: Long = 0,
    val competitiveRank: Long = 0,
    val rankTier: Long = 0,
    val leaderboardRank: Long = 0,
    val profile: PlayerInfoData = PlayerInfoData(),
)

fun PlayerProfileData.mapToDomain() = PlayerProfileDomainData(
    soloCompetitiveRank,
    competitiveRank,
    rankTier,
    leaderboardRank,
    profile
)