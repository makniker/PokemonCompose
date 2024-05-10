package com.example.pokemoncompose.ui.pokelist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.pokemoncompose.R
import com.example.pokemoncompose.data.models.Pokemon
import com.example.pokemoncompose.ui.components.PokemonCard
import com.example.pokemoncompose.ui.components.PokemonImage
import com.example.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    pokemonViewModel: PokemonListViewModel,
    onPokemonClick: (PokemonListUiModel) -> Unit = {}
) {
    val list = pokemonViewModel.pokemonList.collectAsLazyPagingItems()
    PokemonList(list = list) {
        
    }
}

@Composable
fun PokemonList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<PokemonListUiModel>,
    onClick: (PokemonListUiModel) -> Unit
) {
    LazyColumn(
        modifier
    ) {
        items(count = list.itemCount) { index ->
            val pokemon = list[index]!!
            PokemonCard(item = pokemon, onPokemonSelected = {
                onClick(pokemon)
            })
            Divider()
        }
    }
}

