package com.example.feature.matches.domain

interface MatchesRepository {

    suspend fun getMatches(query: Int): List<MatchDomainData>
}