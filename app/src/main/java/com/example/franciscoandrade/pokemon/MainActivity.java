package com.example.franciscoandrade.pokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.franciscoandrade.pokemon.models.Pokemon;
import com.example.franciscoandrade.pokemon.models.PokemonResponse;
import com.example.franciscoandrade.pokemon.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    //Instance of Retrofit and make it global
    private Retrofit retrofit;

    //TAG
    private static final String TAG = "POKEDEX";

    //RecyclerView
    private RecyclerView recyclerView;
    private ListPokemonAdapter listPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        listPokemonAdapter= new ListPokemonAdapter();
        recyclerView.setAdapter(listPokemonAdapter);

        GridLayoutManager layoutManager= new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);




        //bring retrofit builder into retrofit with base url and gson reformat  and at the end build it
        retrofit = new Retrofit.Builder().baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Create method to get data
        getData();

    }

    private void getData() {

       //Create an interface which has all methods to interact with the api
       //Use interface with info
        //Create a retrofit with interace
        PokeapiService service= retrofit.create(PokeapiService.class);
        //get methods into a object Call<PokemonResponse> pokemonResponseCall
        Call<PokemonResponse> pokemonResponseCall = service.getPokemonList();
        //service can ise methods

        pokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            //Execute when gets response
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()){
                    //return list of objects
                    PokemonResponse pokemonResponse= response.body();
                    ArrayList<Pokemon> pokemonList= pokemonResponse.getResults();


                    listPokemonAdapter.addListPokemon(pokemonList);


//                    for (int i=0; i <pokemonList.size(); i++){
//                        Pokemon p =pokemonList.get(i);
//                        Log.e(TAG, "Pokemon: "+p.getName() );
//
//                    }
                }

                else{
                    Log.e(TAG, "onResponse "+response.errorBody() );
                }

            }

            //Execute when problem occurs
            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );

            }
        });


    }
}
