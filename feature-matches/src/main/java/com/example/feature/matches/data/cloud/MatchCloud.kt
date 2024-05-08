package com.example.feature.matches.data.cloud

import com.example.feature.matches.data.MatchData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchCloud(
    @SerialName("match_id") val matchId: Long? = 0,
    @SerialName("duration") val duration: Long? = 0,
    @SerialName("start_time") val startTime: Long? = 0,
    @SerialName("radiant_team_id") val radiantTeamId: String? = " ",
    @SerialName("radiant_name") val radiantName: String? = " ",
    @SerialName("dire_team_id") val direTeamId: String? = " ",
    @SerialName("dire_name") val direName: String? = " ",
    @SerialName("leagueid") val leagueId: Long? = 0,
    @SerialName("league_name") val leagueName: String? = " ",
    @SerialName("series_id") val seriesid: Long? = 0,
    @SerialName("series_type") val seriesType: Long? = 0,
    @SerialName("radiant_score") val radiantScore: Long? = 0,
    @SerialName("dire_score") val direScore: Long? = 0,
    @SerialName("radiant_win") val radiantWin: Boolean = false,
    @SerialName("radiant") val radiant: Boolean = false,
)

fun MatchCloud.mapToData() = MatchData(
    matchId,
    duration,
    startTime,
    radiantTeamId,
    radiantName,
    direTeamId,
    direName,
    leagueId,
    leagueName,
    seriesid
)
