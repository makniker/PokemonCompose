package com.example.pokemoncompose.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.pokemoncompose.R


@Composable
fun PokemonImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = "Pokemon"
) {
    AsyncImage(
        model = url,
        modifier = modifier,
        contentScale = ContentScale.FillWidth,
        contentDescription = contentDescription,
        placeholder = painterResource(R.drawable.ic_pokeball)
    )
}
