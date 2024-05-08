package com.example.feature.player.profile.di

import com.example.feature.player.profile.data.PlayerProfileRepositoryImpl
import com.example.feature.player.profile.data.cloud.PlayerProfileCloudDataSource
import com.example.feature.player.profile.data.cloud.PlayerProfileCloudDataSourceImpl
import com.example.feature.player.profile.domain.repository.PlayerProfileRepository
import com.example.feature.player.profile.domain.usecase.FetchPlayerProfileFromCloudUseCase
import com.example.feature.player.profile.domain.usecase.FetchPlayerProfileFromCloudUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object FeaturePlayerProfileModule {

    @Provides
    fun providePlayerProfileCloudDataSource(): PlayerProfileCloudDataSource =
        PlayerProfileCloudDataSourceImpl()

    @Provides
    fun providePlayerProfileRepository(playerProfileCloudDataSource: PlayerProfileCloudDataSource): PlayerProfileRepository =
        PlayerProfileRepositoryImpl(playerProfileCloudDataSource)

    @Provides
    fun provideFetchPlayerProfileFromCloudUseCase(playerProfileRepository: PlayerProfileRepository): FetchPlayerProfileFromCloudUseCase =
        FetchPlayerProfileFromCloudUseCaseImpl(playerProfileRepository)

}