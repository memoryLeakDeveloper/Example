package com.example.feature.players.domain.repository

import com.example.feature.players.domain.models.PlayerDomainData

interface PlayersRepository {

    suspend fun getPlayers(query: String): List<PlayerDomainData>
}