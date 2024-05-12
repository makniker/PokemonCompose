package com.example.pokemoncompose.ui

import com.example.pokemoncompose.data.Pokemon
import com.example.pokemoncompose.data.cache.PokemonCacheModel
import com.example.pokemoncompose.data.network.PokemonNetworkModel
import com.example.pokemoncompose.ui.details.PokemonDetailsUiModel
import com.example.pokemoncompose.ui.pokelist.PokemonListUiModel

fun mapCacheModelToPokemon(cacheModel: PokemonCacheModel): Pokemon {
    with(cacheModel) {
        return Pokemon(
            name = name,
            height = height,
            weight = weight,
            sprites = sprites,
            types = types,
            previewUrl = previewUrl,
        )
    }
}

fun mapNetworkModelToPokemon(networkModel: PokemonNetworkModel) =
    mapCacheModelToPokemon(mapNetworkModelToCacheModel(networkModel))

fun mapNetworkModelToCacheModel(networkModel: PokemonNetworkModel): PokemonCacheModel {
    with(networkModel) {
        val fetchedSprites: List<String> = if (isDefault) {
            listOf(
                sprites.frontDefault!!,
                sprites.backDefault!!,
                sprites.frontShiny!!,
                sprites.backShiny!!
            )
        } else {
            listOf(
                sprites.frontFemale!!,
                sprites.backFemale!!,
                sprites.frontShinyFemale!!,
                sprites.backShinyFemale!!
            )
        }
        val previewUrl = if (isDefault) {
            sprites.frontDefault!!
        } else {
            sprites.frontFemale!!
        }
        return PokemonCacheModel(
            name = name,
            height = height,
            weight = weight,
            sprites = fetchedSprites,
            types = types.map { it.type.name },
            previewUrl = previewUrl,
        )
    }
}

fun mapPokemonToDetailsUI(pokemon: Pokemon) = PokemonDetailsUiModel(pokemon.name, pokemon.weight, pokemon.height, pokemon.sprites)


fun mapPokemonToListUI(pokemon: Pokemon) = PokemonListUiModel(
    pokemon.name, pokemon.types, pokemon.previewUrl
)

