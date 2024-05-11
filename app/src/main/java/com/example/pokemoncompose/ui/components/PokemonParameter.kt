package com.example.pokemoncompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokemonParameter(title: String, content: String, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = title,
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = content,
            style = MaterialTheme.typography.displayMedium
        )
    }
}