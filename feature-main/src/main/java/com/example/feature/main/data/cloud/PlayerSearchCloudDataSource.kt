package com.example.feature.main.data.cloud

import android.util.Log
import com.example.feature.main.data.PlayerData
import com.foe.common.api.ApiService
import com.foe.common.api.DataSource
import com.foe.common.api.TokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url

interface PlayerSearchCloudDataSource : DataSource {

    suspend fun fetchCloud(query: String): List<PlayerData>
}

internal class PlayerSearchCloudDataSourceImpl(private val client: HttpClient) : PlayerSearchCloudDataSource {

    override suspend fun fetchCloud(query: String): List<PlayerData> = runCatching {
        return@runCatching (client.get {
            url(ApiService.BASE_URL)
            header("Bearer", TokenProvider.token)
            parameter("q", query)
        } as List<PlayerCloud>).map { it.mapToData() }
    }.getOrElse {
        Log.d("bugger", it.stackTraceToString())
        throw it
    }
}