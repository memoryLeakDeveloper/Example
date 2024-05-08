package com.example.common.navigation

enum class Screens(val routeWithParams: String) {

    FEATURE_MAIN("FEATURE_MAIN"),
    FEATURE_PLAYERS("FEATURE_PLAYERS"),
    FEATURE_MATCHES("FEATURE_MATCHES"),
    FEATURE_PLAYER_PROFILE("FEATURE_PLAYER_PROFILE/{accountId}"),

}

object SearchFeature {

    const val searchRoute = "search_nested_route"

    const val searchScreenRoute = "search_screen_route"

}