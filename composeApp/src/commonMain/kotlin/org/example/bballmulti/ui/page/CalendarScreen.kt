package org.example.bballmulti.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.bballmulti.models.Game
import org.example.bballmulti.ui.card.GameCard
import org.example.bballmulti.ui.dropdown.DropDownSeasons
import org.example.bballmulti.ui.layout.ErrorScreen
import org.example.bballmulti.ui.layout.LoadingComponent
import org.example.bballmulti.viewmodels.CalendarVM
import org.example.bballmulti.viewmodels.GameUiState

@Composable
fun CalendarScreen(vm : CalendarVM) {

    val state by vm.uiState.collectAsState()
    when (state) {
        GameUiState.Loading -> {
            LoadingComponent()
        }
        is GameUiState.Error -> ErrorScreen((state as GameUiState.Error).message)
        is GameUiState.Success -> {

            val games = (state as GameUiState.Success).games
            val seasons = (state as GameUiState.Success).seasons

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                DropDownSeasons(
                    vm = vm,
                    seasons = seasons,
                    modifier = Modifier.fillMaxWidth()
                )

                MatchList(
                    games = games,
                    //navController = navController
                )

            }
        }
    }
}

@Composable
fun MatchList(games : List<Game>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(games) { game ->
            GameCard(
                game = game,
                onClick = {
                    //navController.navigate("match_detail/${match.idMatch}")
                }
            )
        }
    }
}