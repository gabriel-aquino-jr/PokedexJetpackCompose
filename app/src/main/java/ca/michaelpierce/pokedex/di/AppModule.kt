package ca.michaelpierce.pokedex.di

import ca.michaelpierce.pokedex.data.remote.PokeApi
import ca.michaelpierce.pokedex.repository.PokemonRepository
import ca.michaelpierce.pokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Annotated as Dagger Module, and InstallIn SingletonComponent to make each
// dependency in this module a Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide classes for repo and api
    // use provide at start of function name
    // Annotate with Singleton and Provides
    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}