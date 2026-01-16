package org.example.bballmulti.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game (
    @SerialName("idMatch") val id: Int,
    @SerialName("numero") val number: Int,
    @SerialName("dateMatch") val gameDate: String,
    @SerialName("logoDom") val homeLogo: String,
    @SerialName("equipeDom") val homeTeam: String,
    @SerialName("scoreDom") val homeScore: Int,
    @SerialName("logoExt") val awayLogo: String,
    @SerialName("equipeExt") val awayTeam: String,
    @SerialName("scoreExt") val awayScore: Int,
    @SerialName("idSaison")val season: Int,
) {
    fun getScore(): String {
        return "$homeScore - $awayScore"
    }
}