package com.example.feature.player.profile.domain.usecase

import com.example.feature.player.profile.domain.models.PlayerProfileDomainData
import com.example.feature.player.profile.domain.repository.PlayerProfileRepository
import com.foe.common.api.utils.CloudResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

interface FetchPlayerProfileFromCloudUseCase {

    suspend fun getPlayerProfile(accountId: Long): Flow<CloudResponse<PlayerProfileDomainData>>

}

internal class FetchPlayerProfileFromCloudUseCaseImpl @Inject constructor(private val repository: PlayerProfileRepository) :
    FetchPlayerProfileFromCloudUseCase {

    override suspend fun getPlayerProfile(accountId: Long) =
        flow<CloudResponse<PlayerProfileDomainData>> {
            emit(CloudResponse.Success(repository.getPlayerProfile(accountId)))
        }.onStart {
            emit(CloudResponse.Loading())
        }.catch {
            emit(CloudResponse.Error(it))
        }
}