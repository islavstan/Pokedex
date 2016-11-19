package com.islavdroid.pokedex.pokeApi;

import com.islavdroid.pokedex.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by islav on 19.11.2016.
 */

public interface PokeApiService {

    @GET("pokemon")
    Call<PokemonResponse> getPokemonList(@Query("limit")int limit,@Query("offset")int offset);
}
