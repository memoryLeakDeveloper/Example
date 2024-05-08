package com.example.feature.matches.data.cloud

import android.util.Log
import com.example.feature.matches.data.MatchData
import com.foe.common.api.ApiService
import com.foe.common.api.TokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import javax.inject.Inject

interface MatchesSearchCloudDataSource {

    suspend fun fetchCloud(query: Int): List<MatchData>
}

class MatchesSearchCloudDataSourceImpl @Inject constructor() :
    MatchesSearchCloudDataSource {

    override suspend fun fetchCloud(query: Int): List<MatchData> = runCatching {
        return@runCatching (ApiService().create().get {
            url(ApiService.PRO_MATCHES)
            header("Bearer", TokenProvider.token)
            parameter("q", query)
        } as List<MatchCloud>).map { it.mapToData() }
    }.getOrElse {
        Log.d("bugger", it.stackTraceToString())
        throw it
    }
}