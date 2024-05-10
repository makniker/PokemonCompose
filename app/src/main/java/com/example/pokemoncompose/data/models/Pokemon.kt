package com.example.pokemoncompose.data.models

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("height") val height: Int,
    @SerializedName("held_items") val heldItems: List<Any>,
    @SerializedName("id") val id: Int,
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("location_area_encounters") val locationAreaEncountersUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("types") val types: List<Type>,
    @SerializedName("weight") val weight: Int,
    @SerializedName("sprites") val sprites: Sprites,
)