package com.example.feature.players.domain.usecase

import com.example.feature.players.domain.repository.PlayersRepository
import com.example.feature.players.domain.models.PlayerDomainData
import com.foe.common.api.utils.CloudResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

interface FetchListPlayersFromCloudUseCase {

    suspend fun getPlayers(query: String): Flow<CloudResponse<List<PlayerDomainData>>>

}

internal class FetchListPlayersFromCloudUseCaseImpl @Inject constructor(private val repository: PlayersRepository) :
    FetchListPlayersFromCloudUseCase {

    override suspend fun getPlayers(query: String) = flow<CloudResponse<List<PlayerDomainData>>> {
        emit(CloudResponse.Success(repository.getPlayers(query)))
    }.onStart {
        emit(CloudResponse.Loading())
    }.catch {
        emit(CloudResponse.Error(it))
    }
}