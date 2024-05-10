package com.example.pokemoncompose.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage


@Composable
fun PokemonImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = "Pokemon"
) {
    AsyncImage(
        model = url,
        modifier = modifier,
        contentScale = ContentScale.Fit,
        contentDescription = contentDescription,
    )
}
