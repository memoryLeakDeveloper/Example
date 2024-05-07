package com.example.feature.main.data

import com.example.feature.main.domain.PlayerDomainData

data class PlayerData(
    val accountId: Long? = 0,
    val avatar: String? = " ",
    val name: String? = " ",
    val lastMitchTime: String? = " ",
    val similarity: String? = " ",
)

fun PlayerData.mapToDomain() = PlayerDomainData(accountId, avatar, name, lastMitchTime, similarity)