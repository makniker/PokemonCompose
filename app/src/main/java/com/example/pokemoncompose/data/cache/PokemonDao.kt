package com.example.pokemoncompose.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonCacheModel)

    @Query("SELECT * FROM PokemonCache WHERE name = :name")
    suspend fun getPokemon(name: String): PokemonCacheModel?
}