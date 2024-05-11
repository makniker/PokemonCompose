package com.example.pokemoncompose.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeService: PokeService) {
    fun getPokemonList() = Pager(
        config = PagingConfig(
            pageSize = LOAD_SIZE, enablePlaceholders = true
        ), pagingSourceFactory = {
            PokemonPagingSource(pokeService)
        }
    ).flow

    suspend fun getPokemonInfo(name: String) = pokeService.getPokemonInfo(name)
}