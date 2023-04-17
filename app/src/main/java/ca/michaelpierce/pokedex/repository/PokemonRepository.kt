package ca.michaelpierce.pokedex.repository

import ca.michaelpierce.pokedex.data.remote.PokeApi
import ca.michaelpierce.pokedex.data.remote.responses.Pokemon
import ca.michaelpierce.pokedex.data.remote.responses.PokemonList
import ca.michaelpierce.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

// Scope to an Activity
@ActivityScoped
class PokemonRepository @Inject constructor(
    // Inject API via constructor
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured")
        }

        return Resource.Success(response)
    }

}