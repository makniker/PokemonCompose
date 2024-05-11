package com.example.pokemoncompose.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokemoncompose.data.models.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val LOAD_SIZE = 10

class PokemonPagingSource(private val pokeService: PokeService) : PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val currentPage = params.key ?: 0
        return try {
            val result =
                pokeService.getPokemonList(LOAD_SIZE, LOAD_SIZE * currentPage)
            val list = result.results.map {
                pokeService.getPokemonInfo(it.name)
            }
            LoadResult.Page(
                data = list,
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (result.count == 0) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}