package com.example.app.di

import com.example.app.ui.navigation.NavigationProvider
import com.example.feature.main.ui.navigation.FeatureMainApi
import com.example.feature.search.ui.navigation.FeatureSearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNavigationProvider(featureMainApi: FeatureMainApi, featureSearchApi: FeatureSearchApi): NavigationProvider =
        NavigationProvider(featureMainApi, featureSearchApi)

}