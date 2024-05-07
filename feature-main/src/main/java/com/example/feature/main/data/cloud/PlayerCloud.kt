package com.example.feature.main.data.cloud

import com.example.feature.main.data.PlayerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerCloud(
    @SerialName("account_id") val accountId: Long? = 0,
    @SerialName("avatarfull") val avatar: String? = " ",
    @SerialName("personaname") val name: String? = " ",
    @SerialName("last_match_time") val lastMitchTime: String? = " ",
    @SerialName("similarity") val similarity: String? = " ",
)

fun PlayerCloud.mapToData() = PlayerData(accountId, avatar, name, lastMitchTime, similarity)
