package com.example.pokemoncompose.data.network

import com.example.pokemoncompose.data.network.Sprites
import com.example.pokemoncompose.data.network.Type
import com.google.gson.annotations.SerializedName

data class PokemonNetworkModel(
    @SerializedName("height") val height: Int,
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("types") val types: List<Type>,
    @SerializedName("weight") val weight: Int,
    @SerializedName("sprites") val sprites: Sprites,
)