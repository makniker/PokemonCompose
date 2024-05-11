package com.example.pokemoncompose.ui.pokelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokemoncompose.ui.components.ErrorScreen
import com.example.pokemoncompose.ui.components.PokemonCard

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    pokemonViewModel: PokemonListViewModel,
    onPokemonClick: (PokemonListUiModel) -> Unit = {}
) {
    val list = pokemonViewModel.pokemonList.collectAsLazyPagingItems()
    Box(modifier = Modifier.fillMaxSize()) {
        when (list.loadState.refresh) {
            is LoadState.Error -> ErrorScreen()
            is LoadState.Loading -> CircularProgressIndicator(
                modifier = modifier
                    .width(128.dp)
                    .align(
                        Alignment.Center
                    ),
            )

            is LoadState.NotLoading -> PokemonList(modifier = modifier, list = list) {
                onPokemonClick
            }
        }
    }
}

@Composable
fun PokemonList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<PokemonListUiModel>,
    onClick: (PokemonListUiModel) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier, contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(count = list.itemCount) { index ->
            val pokemon = list[index]!!
            PokemonCard(
                modifier = modifier,
                item = pokemon
            )
        }
    }
}

