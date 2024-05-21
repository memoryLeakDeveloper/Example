package com.example.feature.players.data.cloud

import android.util.Log
import com.example.feature.players.data.PlayerData
import javax.inject.Inject

interface PlayerSearchCloudDataSource {

    suspend fun fetchCloud(query: String): List<PlayerData>
}

internal class PlayerSearchCloudDataSourceImpl @Inject constructor(private val service: PlayerSearchService) :
    PlayerSearchCloudDataSource {

    override suspend fun fetchCloud(query: String): List<PlayerData> = runCatching {
        return@runCatching service.search(query).map { it.mapToData(it) }
    }.getOrElse {
        Log.d("bugger", it.stackTraceToString())
        throw it
    }
}