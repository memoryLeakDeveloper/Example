package com.example.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.common.navigation.Screens
import com.example.common.navigation.SearchFeature
import com.example.feature.main.ui.screen.MainScreen
import com.example.feature.search.ui.screen.SearchScreen
import com.example.feature.search.ui.screen.SearchViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.FEATURE_MAIN) {
        composable(Screens.FEATURE_SEARCH) {
            val viewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(viewModel = viewModel) {
                navController.navigate(Screens.FEATURE_SEARCH)
            }
        }
        composable(Screens.FEATURE_MAIN) {
            MainScreen() {
                navController.navigate(Screens.FEATURE_SEARCH)
            }
        }
    }
}