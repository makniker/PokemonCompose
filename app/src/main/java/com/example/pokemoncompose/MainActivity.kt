package com.example.pokemoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokemoncompose.ui.details.PokemonDetailsScreen
import com.example.pokemoncompose.ui.pokelist.PokemonListScreen
import com.example.pokemoncompose.ui.theme.PokemonComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonApp()
        }
    }
}

@Composable
fun PokemonApp() {
    PokemonComposeTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "pokemon_list_screen") {
            composable("pokemon_list_screen") {
                PokemonListScreen(pokemonViewModel = hiltViewModel(), navController = navController)
            }
            composable(
                "pokemon_detail_screen/{pokemonName}",
                arguments = listOf(navArgument("pokemonName") {
                    type = NavType.StringType
                })
            ) {
                val pokemonName = remember {
                    it.arguments?.getString("pokemonName")
                }
                PokemonDetailsScreen(
                    viewModel = hiltViewModel(), name = pokemonName!!, navController = navController
                )

            }
        }
    }
}
