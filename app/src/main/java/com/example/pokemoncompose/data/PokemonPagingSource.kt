package com.example.pokemoncompose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokemoncompose.data.cache.PokemonDao
import com.example.pokemoncompose.data.network.PokeService
import com.example.pokemoncompose.ui.mapCacheModelToPokemon
import com.example.pokemoncompose.ui.mapNetworkModelToCacheModel
import com.example.pokemoncompose.ui.mapNetworkModelToPokemon

const val LOAD_SIZE = 10

class PokemonPagingSource(private val pokeService: PokeService, private val dao: PokemonDao) :
    PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val currentPage = params.key ?: 0
        try {
            val result = pokeService.getPokemonList(LOAD_SIZE, LOAD_SIZE * currentPage)
            /*
                Получаем чанк с именами следующих покемонов,
                проверяем, есть ли они в бд и отдаем их.
                Если нет, то запрашиваем полную инфу с сервера,
                кладем ее в бд.
            */
            val list = result.results.map {
                val dbRes = dao.getPokemon(it.name)
                if (dbRes == null) {
                    val newValue = pokeService.getPokemonInfo(it.name)
                    dao.insertPokemon(mapNetworkModelToCacheModel(newValue))
                    mapNetworkModelToPokemon(newValue)
                } else {
                    mapCacheModelToPokemon(dbRes)
                }
            }
            return LoadResult.Page(
                data = list,
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (result.count == 0) null else currentPage + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}