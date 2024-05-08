package com.example.feature.matches.domain

data class MatchDomainData(
    val matchId: Long? = 0,
    val duration: Long? = 0,
    val startTime: Long? = 0,
    val radiantTeamId: String? = " ",
    val radiantName: String? = " ",
    val direTeamId: String? = " ",
    val direName: String? = " ",
    val leagueId: Long? = 0,
    val leagueName: String? = " ",
    val seriesid: Long? = 0,
    val seriesType: Long? = 0,
    val radiantScore: Long? = 0,
    val direScore: Long? = 0,
    val radiantWin: Boolean = false,
    val radiant: Boolean = false,
)