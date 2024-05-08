package com.example.feature.player.profile.data.cloud

import com.example.feature.player.profile.data.PlayerInfoData
import com.example.feature.player.profile.data.PlayerProfileData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerProfileCloud(
    @SerialName("solo_competitive_rank") val soloCompetitiveRank: Long? = 0,
    @SerialName("competitive_rank") val competitiveRank: Long? = 0,
    @SerialName("rank_tier") val rankTier: Long? = 0,
    @SerialName("leaderboard_rank") val leaderboardRank: Long? = 0,
    @SerialName("profile") val profile: PlayerInfoCloud? = null,
)

fun PlayerProfileCloud.mapToData() = PlayerProfileData(
    soloCompetitiveRank ?: 0,
    competitiveRank ?: 0,
    rankTier ?: 0,
    leaderboardRank ?: 0,
    profile?.mapToData() ?: PlayerInfoData(),
)
