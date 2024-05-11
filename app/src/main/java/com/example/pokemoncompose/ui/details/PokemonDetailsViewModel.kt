package com.example.pokemoncompose.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemoncompose.data.PokemonRepository
import com.example.pokemoncompose.ui.mapPokemonToDetailsUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState.asStateFlow()

    fun fetchData(name: String) {
        viewModelScope.launch {
            _uiState.value = repository.getPokemonInfo(name).let {
                DetailsUiState.Idle(
                    mapPokemonToDetailsUI(it)
                )
            }
        }
    }
}

sealed interface DetailsUiState {
    data class Idle(val pokemon: PokemonDetailsUiModel) : DetailsUiState
    data object Loading : DetailsUiState
    data class Error(val message: String?) : DetailsUiState
}