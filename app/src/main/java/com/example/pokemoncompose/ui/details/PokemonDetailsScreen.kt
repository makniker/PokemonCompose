package com.example.pokemoncompose.ui.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemoncompose.ui.components.ErrorScreen
import com.example.pokemoncompose.ui.components.PokemonParameter
import com.example.pokemoncompose.ui.components.SpriteGallery
import com.example.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailsViewModel, name: String, navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()
    viewModel.fetchData(name)
    when (val s = uiState) {
        is DetailsUiState.Error -> ErrorScreen { viewModel.fetchData(name) }
        is DetailsUiState.Idle -> Column {
            Column(modifier = Modifier.fillMaxSize()) {
                SpriteGallery(
                    imageUrls = s.pokemon.imageUrls,
                    name = name.replaceFirstChar { it.uppercaseChar() })
                Row {
                    PokemonParameter(
                        title = "Height",
                        content = s.pokemon.height.toString(),
                        modifier = Modifier.weight(1f)
                    )
                    PokemonParameter(
                        title = "Weight",
                        content = s.pokemon.weight.toString(),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { navController.popBackStack() },
                    shape = MaterialTheme.shapes.small,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text("Go back", style = MaterialTheme.typography.displaySmall)
                }
            }
        }

        is DetailsUiState.Loading -> Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = modifier
                    .width(128.dp)
                    .align(
                        Alignment.Center
                    ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsPreview() {
    PokemonComposeTheme {

    }
}