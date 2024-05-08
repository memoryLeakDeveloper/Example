package com.example.feature.players.data

import com.example.feature.players.data.cloud.PlayerSearchCloudDataSource
import com.example.feature.players.domain.repository.PlayersRepository
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(private val playerSearchCloudDataSource: PlayerSearchCloudDataSource) :
    PlayersRepository {

    override suspend fun getPlayers(query: String) =
        playerSearchCloudDataSource.fetchCloud(query).map { it.mapToDomain() }

}