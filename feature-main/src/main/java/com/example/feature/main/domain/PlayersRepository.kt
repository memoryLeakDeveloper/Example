package com.example.feature.main.domain

interface PlayersRepository {

    suspend fun getPlayers(query: String): List<PlayerDomainData>
}