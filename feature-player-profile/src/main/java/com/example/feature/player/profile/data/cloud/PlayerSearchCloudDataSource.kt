package com.example.feature.player.profile.data.cloud

import android.util.Log
import com.example.feature.player.profile.data.PlayerProfileData
import com.foe.common.api.ApiService
import com.foe.common.api.TokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url

interface PlayerProfileCloudDataSource {

    suspend fun fetchCloud(query: Long): PlayerProfileData
}

internal class PlayerProfileCloudDataSourceImpl(private val client: HttpClient = ApiService().create()) :
    PlayerProfileCloudDataSource {

    override suspend fun fetchCloud(query: Long): PlayerProfileData = runCatching {
        return@runCatching (client.get {
            url(ApiService.PLAYER_INFO + "/" + query)
            header("Bearer", TokenProvider.token)
        } as PlayerProfileCloud).mapToData()
    }.getOrElse {
        Log.d("bugger", it.stackTraceToString())
        throw it
    }
}