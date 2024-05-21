package com.example.feature.players.data.cloud

import com.foe.common.api.ApiService
import com.foe.common.api.TokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class PlayerSearchService(private val client: HttpClient = ApiService().create()) {

    suspend fun search(query: String): List<PlayerCloud> {
        return client.get {
            url(ApiService.PLAYERS_SEARCH)
            header("Bearer", TokenProvider.token)
            parameter("q", query)
        }
    }
}