package com.example.feature.players.domain.models

data class PlayerDomainData(
    val accountId: Long? = 0,
    val avatar: String? = " ",
    val name: String? = " ",
    val lastMitchTime: String? = " ",
    val similarity: String? = " ",
)