package com.example.feature.player.profile.data

import com.example.feature.player.profile.data.cloud.PlayerProfileCloudDataSource
import com.example.feature.player.profile.domain.models.PlayerProfileDomainData
import com.example.feature.player.profile.domain.repository.PlayerProfileRepository
import javax.inject.Inject

class PlayerProfileRepositoryImpl @Inject constructor(private val playerProfileCloudDataSource: PlayerProfileCloudDataSource) :
    PlayerProfileRepository {

    override suspend fun getPlayerProfile(accountId: Long): PlayerProfileDomainData {
        return playerProfileCloudDataSource.fetchCloud(accountId).mapToDomain()
    }

}