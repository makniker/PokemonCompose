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
                    PokemonListUiModel(
                        pokemon.name,
                        pokemon.types.map { it.type.name },
                        pokemon.sprites.frontDefault
                    )
                }
            }


    private var cachedPokemonList = listOf<PokemonListUiModel>(
        PokemonListUiModel(
            "aboba",
            listOf("fire", "water"),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
        ),
        PokemonListUiModel(
            "aboba",
            listOf("fire", "water"),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
        ),
        PokemonListUiModel(
            "aboba",
            listOf("fire", "water"),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
        ),
        PokemonListUiModel(
            "aboba",
            listOf("fire", "water"),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
        ),
        PokemonListUiModel(
            "aboba",
            listOf("fire", "water"),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
        )
    )

    init {

    }
}