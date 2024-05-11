package com.example.pokemoncompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemoncompose.ui.pokelist.PokemonListUiModel
import com.example.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    item: PokemonListUiModel,
    onClick: (PokemonListUiModel) -> Unit = {}
) {
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick(item) },
        shape = MaterialTheme.shapes.medium,
    ) {
        PokemonImage(
            url = item.previewUrl,
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = item.name.replaceFirstChar { it.uppercaseChar() },
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
            Row {
                item.types.forEach {
                    SuggestionChip(
                        onClick = {},
                        label = { Text(it, style = MaterialTheme.typography.labelSmall) },
                        Modifier
                            .height(24.dp)
                            .padding(end = 4.dp)
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
                "Poke",
                listOf("fire", "water"),
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
            )
        )
    }
}