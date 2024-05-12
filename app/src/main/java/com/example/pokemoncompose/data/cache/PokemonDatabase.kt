package com.example.pokemoncompose.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PokemonCacheModel::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun PokemonDao() : PokemonDao
}