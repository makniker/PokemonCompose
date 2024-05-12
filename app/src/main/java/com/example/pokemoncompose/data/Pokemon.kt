package com.example.pokemoncompose.data

data class Pokemon(
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: List<String>,
    val types: List<String>,
    val previewUrl: String
)