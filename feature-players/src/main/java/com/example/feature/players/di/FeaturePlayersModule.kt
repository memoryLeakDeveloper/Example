package com.example.feature.players.di

import com.example.feature.players.data.PlayersRepositoryImpl
import com.example.feature.players.data.cloud.PlayerSearchCloudDataSource
import com.example.feature.players.data.cloud.PlayerSearchCloudDataSourceImpl
import com.example.feature.players.domain.repository.PlayersRepository
import com.example.feature.players.domain.usecase.FetchListPlayersFromCloudUseCase
import com.example.feature.players.domain.usecase.FetchListPlayersFromCloudUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object FeaturePlayersModule {

    @Provides
    fun providePlayerSearchCloudDataSource(): PlayerSearchCloudDataSource =
        PlayerSearchCloudDataSourceImpl()

    @Provides
    fun providePlayersRepository(matchesSearchCloudDataSource: PlayerSearchCloudDataSource): PlayersRepository =
        PlayersRepositoryImpl(matchesSearchCloudDataSource)

    @Provides
    fun provideFetchListPlayersFromCloudUseCase(playersRepository: PlayersRepository): FetchListPlayersFromCloudUseCase =
        FetchListPlayersFromCloudUseCaseImpl(playersRepository)

}