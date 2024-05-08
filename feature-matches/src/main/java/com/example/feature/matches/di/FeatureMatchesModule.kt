package com.example.feature.matches.di

import com.example.feature.matches.data.MatchesRepositoryImpl
import com.example.feature.matches.data.cloud.MatchesSearchCloudDataSource
import com.example.feature.matches.data.cloud.MatchesSearchCloudDataSourceImpl
import com.example.feature.matches.domain.FetchListMatchesFromCloudUseCase
import com.example.feature.matches.domain.FetchListMatchesFromCloudUseCaseImpl
import com.example.feature.matches.domain.MatchesRepository
import com.foe.common.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.*

@Module
@InstallIn(ViewModelComponent::class)
class FeatureMatchesModule {

    @Provides
    fun provideMatchesSearchCloudDataSource(): MatchesSearchCloudDataSource =
        MatchesSearchCloudDataSourceImpl()

    @Provides
    fun provideMatchesRepository(matchesSearchCloudDataSource: MatchesSearchCloudDataSource): MatchesRepository =
        MatchesRepositoryImpl(matchesSearchCloudDataSource)

    @Provides
    fun provideFetchListMatchesFromCloudUseCase(matchesRepository: MatchesRepository): FetchListMatchesFromCloudUseCase =
        FetchListMatchesFromCloudUseCaseImpl(matchesRepository)
}