package org.example.bballmulti.viewmodels

import org.example.bballmulti.network.GameApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.bballmulti.models.Game
import org.example.bballmulti.models.Season

sealed class GameUiState {
    data object Loading : GameUiState()
    data class Success(val games: List<Game>, val seasons: List<Season>) : GameUiState()
    data class Error(val message: String) : GameUiState()

}

class CalendarVM (
    private val api: GameApi
) : ViewModel() {

    private val _uiState = MutableStateFlow<GameUiState>(GameUiState.Loading)

    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private val _allGames = MutableStateFlow<List<Game>>(emptyList())

    private val _selectedSeason = MutableStateFlow<Season?>(null)

    val selectedSeason : StateFlow<Season?> = _selectedSeason.asStateFlow()
    

    init {
        getGames()
    }

    fun getGames(){
        viewModelScope.launch {
            _uiState.value = GameUiState.Loading

            try {
                val result = api.getAllGames()
                val resultSeason = api.getAllSeason()

                if (result.isNotEmpty() && resultSeason.isNotEmpty()) {
                    _selectedSeason.value = resultSeason.last()
                    _allGames.value = result
                    _uiState.value = GameUiState.Success(result.filter { game -> game.season == selectedSeason.value?.id }, resultSeason)
                } else {
                    _uiState.value = GameUiState.Error("No data found")
                }
            } catch (e: Exception) {
                _uiState.value = GameUiState.Error(e.message ?: "Unknown error")
                println(e)
            }
        }
    }

    fun onSelectedSeason(season: Season) {
        _selectedSeason.value = season

        val currentState = _uiState.value
        if (currentState !is GameUiState.Success) return

        val filteredGames =
            _allGames.value.filter { it.season == season.id }

        _uiState.value = currentState.copy(
            games = filteredGames
        )
    }

}