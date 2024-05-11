package com.example.pokemoncompose.data.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("name") val name: String,
)