package com.example.common.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens {

    @Serializable
    object Main : Screens

    @Serializable
    object Players : Screens

    @Serializable
    object Matches : Screens

    @Serializable
    data class PlayerProfile(val accountId: Long, val accountName: String) : Screens

}