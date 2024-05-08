package com.example.feature.players.data.cloud

import android.util.Log
import com.example.feature.players.data.PlayerData
import com.foe.common.api.ApiService
import com.foe.common.api.TokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url

interface PlayerSearchCloudDataSource {

    suspend fun fetchCloud(query: String): List<PlayerData>
}

internal class PlayerSearchCloudDataSourceImpl(private val client: HttpClient = ApiService().create()) :
    PlayerSearchCloudDataSource {

    override suspend fun fetchCloud(query: String): List<PlayerData> = runCatching {
        return@runCatching (client.get {
            url(ApiService.PLAYERS_SEARCH)
            header("Bearer", TokenProvider.token)
            parameter("q", query)
        } as List<PlayerCloud>).map { it.mapToData() }
    }.getOrElse {
        Log.d("bugger", it.stackTraceToString())
        throw it
    }
}