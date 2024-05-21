package com.example.feature.players.data.cloud

import com.example.common.mapping.CloudModel
import com.example.common.mapping.CloudToDataMapper
import com.example.feature.players.data.PlayerData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerCloud(
    @SerialName("account_id") val accountId: Long? = 0,
    @SerialName("avatarfull") val avatar: String? = " ",
    @SerialName("personaname") val name: String? = " ",
    @SerialName("last_match_time") val lastMitchTime: String? = " ",
    @SerialName("similarity") val similarity: String? = " ",
) : CloudModel, CloudToDataMapper<PlayerCloud, PlayerData> {

    override fun mapToData(cloud: PlayerCloud): PlayerData {
        return PlayerData(
            cloud.accountId,
            cloud.avatar,
            cloud.name,
            cloud.lastMitchTime,
            cloud.similarity
        )
    }
}
