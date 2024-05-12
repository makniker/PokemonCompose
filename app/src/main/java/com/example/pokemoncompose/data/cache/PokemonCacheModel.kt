package com.example.pokemoncompose.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
    Копия класса Pokemon, сделал отдельную модель для кеша,
    тк возможно в будущем понадобиться хранить в бд новые поля,
    не предусмотренные моделью, которую отдаем из репозитория
*/

@Entity(tableName = "PokemonCache")
class PokemonCacheModel(
    @PrimaryKey val name: String,
    @ColumnInfo("height") val height: Int,
    @ColumnInfo("weight") val weight: Int,
    @ColumnInfo("sprites") val sprites: List<String>,
    @ColumnInfo("types") val types: List<String>,
    @ColumnInfo("previewUrl") val previewUrl: String
)