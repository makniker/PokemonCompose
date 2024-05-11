package com.example.pokemoncompose.ui.pokelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.pokemoncompose.data.PokemonRepository
import com.example.pokemoncompose.ui.mapPokemonToListUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    repository: PokemonRepository
) : ViewModel() {
    val pokemonList =
        repository.getPokemonList().map { pagingData ->
            pagingData.map {
                mapPokemonToListUI(it)
            }
        }.cachedIn(viewModelScope)
}