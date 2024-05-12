package com.example.pokemoncompose.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.pokemoncompose.data.cache.PokemonDao
import com.example.pokemoncompose.data.network.PokeService
import com.example.pokemoncompose.ui.mapCacheModelToPokemon
import com.example.pokemoncompose.ui.mapNetworkModelToCacheModel
import com.example.pokemoncompose.ui.mapNetworkModelToPokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokeService: PokeService,
    private val dao: PokemonDao
) {
    fun getPokemonList() = Pager(config = PagingConfig(
        pageSize = LOAD_SIZE, enablePlaceholders = true
    ), pagingSourceFactory = {
        PokemonPagingSource(pokeService, dao)
    }).flow

    suspend fun getPokemonInfo(name: String): Pokemon {
        val dbRes = dao.getPokemon(name)
        return if (dbRes == null) {
            val newValue = pokeService.getPokemonInfo(name)
            dao.insertPokemon(mapNetworkModelToCacheModel(newValue))
            mapNetworkModelToPokemon(newValue)
        } else {
            mapCacheModelToPokemon(dbRes)
        }
    }
}