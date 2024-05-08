package com.example.feature.player.profile.domain.repository

import com.example.feature.player.profile.domain.models.PlayerProfileDomainData

interface PlayerProfileRepository {

    suspend fun getPlayerProfile(accountId: Long): PlayerProfileDomainData
}