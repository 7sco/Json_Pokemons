package com.example.franciscoandrade.pokemon.pokeapi;



import com.example.franciscoandrade.pokemon.models.PokemonResponse;

import retrofit2.http.GET;
import retrofit2.Call;

public interface PokeapiService {

    //For now we want to access the pokemon list
    //we create a method to get that lis

    //Specify the action and url
    //'pokemon' is part of url missing to get the json
    @GET("pokemon")
    Call<PokemonResponse> getPokemonList();
}
