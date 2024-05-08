package com.example.feature.player.profile.data.cloud

import com.example.feature.player.profile.data.PlayerInfoData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerInfoCloud(
    @SerialName("account_id") val accountId: Long? = 0,
    @SerialName("personaname") val personaName: String? = "",
    @SerialName("name") val name: String? = "",
    @SerialName("plus") val plus: Boolean? = false,
    @SerialName("cheese") val cheese: Long? = 0,
    @SerialName("steamid") val steamId: String? = "",
    @SerialName("avatar") val avatar: String? = "",
    @SerialName("avatarmedium") val avatarMedium: String? = "",
    @SerialName("avatarfull") val avatarFull: String? = "",
    @SerialName("profileurl") val profileUrl: String? = "",
    @SerialName("last_login") val lastLogin: String? = "",
    @SerialName("loccountrycode") val locCountryCode: String? = "",
    @SerialName("is_contributor") val isContributor: Boolean? = false,
    @SerialName("is_subscriber") val isSubscriber: Boolean? = false,
)

fun PlayerInfoCloud.mapToData() = PlayerInfoData(
    accountId ?: 0,
    personaName ?: "",
    name ?: "",
    plus ?: false,
    cheese ?: 0,
    steamId ?: "",
    avatar ?: "",
    avatarMedium ?: "",
    avatarFull ?: "",
    profileUrl ?: "",
    lastLogin ?: "",
    locCountryCode ?: "",
    isContributor ?: false,
    isSubscriber ?: false,
)