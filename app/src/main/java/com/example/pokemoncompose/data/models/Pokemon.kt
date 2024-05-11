package com.example.pokemoncompose.data.models

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("height") val height: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("types") val types: List<Type>,
    @SerializedName("weight") val weight: Int,
    @SerializedName("sprites") val sprites: Sprites,
)