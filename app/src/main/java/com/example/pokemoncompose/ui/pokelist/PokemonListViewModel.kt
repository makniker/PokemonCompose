package com.example.pokemoncompose.ui.pokelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.pokemoncompose.data.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

sealed interface MarsUiState {
    data class Success(val photos: List<PokemonListUiModel>) : MarsUiState
    object Error : MarsUiState
    object Loading : MarsUiState
}

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    val pokemonList =
        repository.getPokemonList()
            .cachedIn(viewModelScope).map { pagingData ->
                pagingData.map { pokemon ->
                    if (pokemon.sprites.frontDefault != null) {
                        PokemonListUiModel(
                            pokemon.id.toString(),
                            pokemon.types.map { it.type.name },
                            pokemon.sprites.frontDefault
                        )
                    } else if (pokemon.sprites.frontFemale != null) {
                        PokemonListUiModel(
                            pokemon.id.toString(),
                            pokemon.types.map { it.type.name },
                            pokemon.sprites.frontFemale
                        )
                    } else if (pokemon.sprites.frontShiny != null) {
                        PokemonListUiModel(
                            pokemon.id.toString(),
                            pokemon.types.map { it.type.name },
                            pokemon.sprites.frontShiny
                        )
                    } else {
                        PokemonListUiModel(
                            pokemon.id.toString(),
                            pokemon.types.map { it.type.name },
                            pokemon.sprites.frontShinyFemale!!
                        )
                    }
                }
            }
}