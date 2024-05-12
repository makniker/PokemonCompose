package com.example.pokemoncompose.data.network

import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("name") val name: String,
    @SerializedName("url") val typeUrl: String
)