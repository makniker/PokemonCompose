package com.example.pokemoncompose.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokemoncompose.data.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeService: PokeService) {
    fun getPokemonList() = Pager(
        config = PagingConfig(
            pageSize = LOAD_SIZE,  enablePlaceholders = true
        ), pagingSourceFactory = {
            PokemonPagingSource(pokeService)
        }
    ).flow
}