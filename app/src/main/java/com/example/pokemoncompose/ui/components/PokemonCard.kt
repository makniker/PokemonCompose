package com.example.pokemoncompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemoncompose.ui.pokelist.PokemonListUiModel
import com.example.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    item: PokemonListUiModel,
    onPokemonSelected: (PokemonListUiModel) -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
    ) {
        PokemonImage(
            url = item.previewUrl!!, modifier = Modifier
                .size(160.dp)
                .fillMaxWidth(1f)
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
            Row {
                item.types.forEach {
                    SuggestionChip(
                        onClick = {},
                        label = { Text(it) }, Modifier.height(24.dp).padding(end=4.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PokemonItemPreview() {
    PokemonComposeTheme {
        PokemonCard(
            item = PokemonListUiModel(
                "Aboba",
                listOf("fire", "water"),
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
            )
        )
    }
}