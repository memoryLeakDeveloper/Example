package com.example.feature.main.data

import com.example.feature.main.data.cloud.PlayerSearchCloudDataSource
import com.example.feature.main.domain.PlayersRepository
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(private val playerSearchCloudDataSource: PlayerSearchCloudDataSource) :
    PlayersRepository {

    override suspend fun getPlayers(query: String) = playerSearchCloudDataSource.fetchCloud(query).map { it.mapToDomain() }

}