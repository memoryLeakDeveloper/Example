package com.example.feature.main.di

import com.example.feature.main.ui.navigation.FeatureMainApi
import com.example.feature.main.ui.navigation.FeatureMainApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object FeatureMainModule {

    @Provides
    fun provideFeatureMainApiApi(): FeatureMainApi = FeatureMainApiImpl()

}