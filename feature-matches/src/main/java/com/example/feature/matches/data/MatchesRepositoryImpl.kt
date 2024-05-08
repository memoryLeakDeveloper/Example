package com.example.feature.matches.data

import com.example.feature.matches.data.cloud.MatchesSearchCloudDataSource
import com.example.feature.matches.domain.MatchesRepository
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(private val matchesSearchCloudDataSource: MatchesSearchCloudDataSource) :
    MatchesRepository {

    override suspend fun getMatches(query: Int) =
        matchesSearchCloudDataSource.fetchCloud(query).map { it.mapToDomain() }

}