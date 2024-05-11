package com.example.pokemoncompose.ui

import com.example.pokemoncompose.data.models.Pokemon
import com.example.pokemoncompose.ui.details.PokemonDetailsUiModel
import com.example.pokemoncompose.ui.pokelist.PokemonListUiModel

fun mapPokemonToDetailsUI(pokemon: Pokemon): PokemonDetailsUiModel {
    val list: List<String> = if (pokemon.isDefault) {
        listOf(
            pokemon.sprites.frontDefault!!,
            pokemon.sprites.backDefault!!,
            pokemon.sprites.frontShiny!!,
            pokemon.sprites.backShiny!!
        )
    } else {
        listOf(
            pokemon.sprites.frontFemale!!,
            pokemon.sprites.backFemale!!,
            pokemon.sprites.frontShinyFemale!!,
            pokemon.sprites.backShinyFemale!!
        )
    }
    return PokemonDetailsUiModel(pokemon.name, pokemon.weight, pokemon.height, list)
}

fun mapPokemonToListUI(pokemon: Pokemon): PokemonListUiModel =
    PokemonListUiModel(
        pokemon.name,
        pokemon.types.map { it.type.name },
        pokemon.sprites.frontDefault
            ?: (pokemon.sprites.frontFemale
                ?: (pokemon.sprites.frontShiny
                    ?: pokemon.sprites.frontShinyFemale!!)),
    )

