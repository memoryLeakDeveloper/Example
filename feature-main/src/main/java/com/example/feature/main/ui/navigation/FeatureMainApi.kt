package com.example.feature.main.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.navigation.Screens
import com.example.common.navigation.SearchFeature
import com.example.feature.api.FeatureApi
import com.example.feature.main.ui.screen.MainScreen

interface FeatureMainApi : FeatureApi

class FeatureMainApiImpl : FeatureMainApi {


    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(route = Screens.FEATURE_MAIN, startDestination = SearchFeature.searchScreenRoute) {
            composable(SearchFeature.searchScreenRoute) {
                MainScreen() {
                    navController.navigate(Screens.FEATURE_SEARCH)
                }
            }
        }
    }
}