package com.example.pokemoncompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun SpriteGallery(imageUrls: List<String>, name: String) {
    val shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 32.dp,
        bottomEnd = 32.dp,
    )
    Column {
        Card(shape = shape, modifier = Modifier.shadow(elevation = 9.dp, shape = shape)) {
            Column {
                Row {
                    PokemonImage(url = imageUrls[0], Modifier.fillMaxWidth(0.5f))
                    PokemonImage(url = imageUrls[1], Modifier.fillMaxWidth())
                }
                Row {
                    PokemonImage(url = imageUrls[2], Modifier.fillMaxWidth(0.5f))
                    PokemonImage(url = imageUrls[3], Modifier.fillMaxWidth())
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Text(text = name, modifier = Modifier.align(Alignment.CenterHorizontally), style = MaterialTheme.typography.displayLarge)
    }
}

@Composable
@Preview(showBackground = true)
fun SpriteGalleryPreview() {
    PokemonComposeTheme {
        SpriteGallery(
            imageUrls = listOf(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png"
            ), name = "Poke"
        )
    }
}
