package com.example.feature.player.profile.domain.models

data class PlayerInfoDomainData(
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
)