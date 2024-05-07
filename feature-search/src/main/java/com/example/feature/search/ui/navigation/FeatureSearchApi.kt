package com.example.feature.search.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.navigation.Screens
import com.example.common.navigation.SearchFeature
import com.example.feature.api.FeatureApi
import com.example.feature.search.ui.screen.SearchScreen
import com.example.feature.search.ui.screen.SearchViewModel

interface FeatureSearchApi : FeatureApi

class FeatureSearchApiImpl : FeatureSearchApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(route = Screens.FEATURE_SEARCH, startDestination = SearchFeature.searchScreenRoute) {
            composable(SearchFeature.searchScreenRoute) {
                val viewModel = hiltViewModel<SearchViewModel>()
                SearchScreen(viewModel = viewModel) {
                    navController.navigate(Screens.FEATURE_SEARCH)
                }
            }
        }
    }
}