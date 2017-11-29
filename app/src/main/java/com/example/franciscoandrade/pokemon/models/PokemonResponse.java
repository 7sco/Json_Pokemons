package com.example.franciscoandrade.pokemon.models;

import java.util.ArrayList;

/**
 * Created by franciscoandrade on 11/29/17.
 */

public class PokemonResponse {

    //we create the atributes we need from the json
    //for now we only need the array 'results'
//    {
//        count: 949,
//        previous: null,
//        results: (20)[
//            {
//                url: https://pokeapi.co/api/v2/pokemon/1/,
//                name: "bulbasaur"
//            },
//            {
//                url: https://pokeapi.co/api/v2/pokemon/2/,
//                name: "ivysaur"
//            },

    //Make sure we use same variable names
    //Create a class with info needed 'Pokemon'

    private ArrayList<Pokemon> results;

    //Create Getter and Setter


    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
