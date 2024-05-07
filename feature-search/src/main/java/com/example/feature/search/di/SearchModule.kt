package com.example.feature.search.di

import com.example.feature.search.ui.navigation.FeatureSearchApi
import com.example.feature.search.ui.navigation.FeatureSearchApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object SearchModule {

    @Provides
    fun provideFeatureSearchApi(): FeatureSearchApi = FeatureSearchApiImpl()

}