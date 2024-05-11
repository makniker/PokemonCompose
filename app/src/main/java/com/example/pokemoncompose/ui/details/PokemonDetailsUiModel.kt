package com.example.pokemoncompose.ui.details

data class PokemonDetailsUiModel(
    val name: String,
    val weight: Int,
    val height: Int,
    val imageUrls: List<String>
)