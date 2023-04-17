package ca.michaelpierce.pokedex.data.remote

import ca.michaelpierce.pokedex.data.remote.responses.Pokemon
import ca.michaelpierce.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        // pass these parameters into the URL get request as parameters
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        // Pass the name into the URL
        @Path("name") name: String
    ) : Pokemon
}