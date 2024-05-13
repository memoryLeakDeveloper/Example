package com.example.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
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

    NavHost(navController = navController, startDestination = Screens.Main) {
        composable<Screens.Main> {
            MainScreen(viewModel = hiltViewModel<MainScreenViewModel>()) {
                when (it) {
                    Screens.Matches -> navController.navigate(Screens.Matches)
                    Screens.Players -> navController.navigate(Screens.Players)
                    else -> {}
                }
            }
        }
        composable<Screens.Players> {
            val viewModel = hiltViewModel<PlayersScreenViewModel>()
            PlayersScreen(viewModel = viewModel) { id, name ->
                navController.navigate(Screens.PlayerProfile(id, name))
            }
        }
        composable<Screens.Matches> {
            MatchesScreen(hiltViewModel<MatchesScreenViewModel>()) {
            }
        }
        composable<Screens.PlayerProfile> { backStackEntry ->
            val profile = backStackEntry.toRoute<Screens.PlayerProfile>()
            PlayerProfileScreen(
                profile.accountId,
                profile.accountName,
                hiltViewModel<PlayerProfileScreenViewModel>()
            ) {
                navController.navigateUp()
            }
        }
    }
}