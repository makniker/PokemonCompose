package com.example.pokemoncompose.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PokemonCache")
class PokemonCacheModel(
    @PrimaryKey val name: String,
    @ColumnInfo("height") val height: Int,
    @ColumnInfo("weight") val weight: Int,
    @ColumnInfo("sprites") val sprites: List<String>,
    @ColumnInfo("types") val types: List<String>,
    @ColumnInfo("previewUrl") val previewUrl: String
)