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

