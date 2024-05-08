package com.example.feature.matches.domain

import com.foe.common.api.utils.CloudResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

interface FetchListMatchesFromCloudUseCase {

    suspend fun getMatches(query: Int): Flow<CloudResponse<List<MatchDomainData>>>

}

internal class FetchListMatchesFromCloudUseCaseImpl @Inject constructor(private val repository: MatchesRepository) :
    FetchListMatchesFromCloudUseCase {

    override suspend fun getMatches(query: Int) = flow<CloudResponse<List<MatchDomainData>>> {
        emit(CloudResponse.Success(repository.getMatches(query)))
    }.onStart {
        emit(CloudResponse.Loading())
    }.catch {
        emit(CloudResponse.Error(it))
    }
}