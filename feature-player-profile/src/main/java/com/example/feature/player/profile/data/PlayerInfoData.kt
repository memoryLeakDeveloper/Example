package com.example.feature.player.profile.data

import com.example.feature.player.profile.Mapper
import com.example.feature.player.profile.domain.models.PlayerInfoDomainData

data class PlayerInfoData(
    val accountId: Long = 0,
    val personaName: String = "",
    val name: String = "",
    val plus: Boolean = false,
    val cheese: Long = 0,
    val steamId: String = "",
    val avatar: String = "",
    val avatarMedium: String = "",
    val avatarFull: String = "",
    val profileUrl: String = "",
    val lastLogin: String = "",
    val locCountryCode: String = "",
    val isContributor: Boolean = false,
    val isSubscriber: Boolean = false,
): Mapper<PlayerInfoData, PlayerInfoDomainData> {
    override fun mapTo(first: PlayerInfoData): PlayerInfoDomainData {
        TODO("Not yet implemented")
    }
}

fun PlayerInfoData.mapToDomain() = PlayerInfoDomainData(
    accountId,
    personaName,
    name,
    plus,
    cheese,
    steamId,
    avatar,
    avatarMedium,
    avatarFull,
    profileUrl,
    lastLogin,
    locCountryCode,
    isContributor,
    isSubscriber
)