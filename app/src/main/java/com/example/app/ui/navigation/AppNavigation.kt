package com.example.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.common.navigation.Screens
import com.example.feature.main.ui.screen.MainScreen
import com.example.feature.main.ui.screen.MainScreenViewModel
import com.example.feature.matches.ui.screen.MatchesScreen
import com.example.feature.matches.ui.screen.MatchesScreenViewModel
import com.example.feature.player.profile.ui.screen.PlayerProfileScreen
import com.example.feature.player.profile.ui.screen.PlayerProfileScreenViewModel
import com.example.feature.players.ui.screen.PlayersScreen
import com.example.feature.players.ui.screen.PlayersScreenViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.FEATURE_MAIN.name) {
        composable(Screens.FEATURE_MAIN.name) {
            MainScreen(viewModel = hiltViewModel<MainScreenViewModel>()) {
                when (it) {
                    Screens.FEATURE_MATCHES -> navController.navigate(Screens.FEATURE_MATCHES.name)
                    Screens.FEATURE_PLAYERS -> navController.navigate(Screens.FEATURE_PLAYERS.name)
                    else -> {}
                }
            }
        }
        composable(Screens.FEATURE_PLAYERS.name) {
            val viewModel = hiltViewModel<PlayersScreenViewModel>()
            PlayersScreen(viewModel = viewModel) {
                navController.navigate(Screens.FEATURE_PLAYER_PROFILE.name + "/$it")
            }
        }
        composable(Screens.FEATURE_MATCHES.name) {
            MatchesScreen(hiltViewModel<MatchesScreenViewModel>()) {
            }
        }
        composable(
            Screens.FEATURE_PLAYER_PROFILE.routeWithParams,
            arguments = listOf(navArgument("accountId") {
                type = NavType.LongType
            })
        ) {
            PlayerProfileScreen(
                it.arguments?.getLong("accountId") ?: 0L,
                hiltViewModel<PlayerProfileScreenViewModel>()
            ) {

            }
        }
    }
}