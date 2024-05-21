package com.example.feature.players.data

import com.example.common.mapping.DataModel
import com.example.common.mapping.DataToDomainMapper
import com.example.feature.players.domain.models.PlayerDomainData

data class PlayerData(
    val accountId: Long? = 0,
    val avatar: String? = " ",
    val name: String? = " ",
    val lastMitchTime: String? = " ",
    val similarity: String? = " ",
) : DataModel, DataToDomainMapper<PlayerData, PlayerDomainData> {
    override fun mapToDomain(data: PlayerData): PlayerDomainData {
        return PlayerDomainData(
            data.accountId,
            data.avatar,
            data.name,
            data.lastMitchTime,
            data.similarity
        )
    }
}
