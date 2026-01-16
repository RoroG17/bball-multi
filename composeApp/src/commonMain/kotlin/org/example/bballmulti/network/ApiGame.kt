package org.example.bballmulti.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.example.bballmulti.models.Game
import org.example.bballmulti.models.Season

interface GameApi {
    suspend fun getAllGames(): List<Game>

    suspend fun getAllSeason(): List<Season>
}

class GamesApiImpl(private val client: HttpClient) : GameApi {

    override suspend fun getAllGames(): List<Game> =
        client.get("https://statmatch.alwaysdata.net/api/matchs").body()

    override suspend fun getAllSeason(): List<Season> =
        client.get("https://statmatch.alwaysdata.net/api/saisons").body()
}