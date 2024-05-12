package com.example.pokemoncompose.di

import android.content.Context
import androidx.room.Room
import com.example.pokemoncompose.data.network.PokeService
import com.example.pokemoncompose.data.cache.PokemonDatabase
import com.example.pokemoncompose.data.cache.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Singleton
    @Provides
    fun providePokeService(): PokeService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeService::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, PokemonDatabase::class.java, "POKEMON_DATABASE.db"
    ).build()

    @Singleton
    @Provides
    fun providePokemonDao(database: PokemonDatabase) = database.PokemonDao()

}