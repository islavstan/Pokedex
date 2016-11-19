package com.islavdroid.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islavdroid.pokedex.model.Pokemon;
import com.islavdroid.pokedex.model.PokemonResponse;
import com.islavdroid.pokedex.pokeApi.PokeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private Retrofit retrofit;
    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;
    private static final String URL ="http://pokeapi.co/api/v2/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        pokemonListAdapter=new PokemonListAdapter();
        recyclerView.setAdapter(pokemonListAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        retrofit =new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        getData();
    }
    private void getData(){
        PokeApiService pokeApiService =retrofit.create(PokeApiService.class);
        Call<PokemonResponse>call =pokeApiService.getPokemonList();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if(response.isSuccessful()){
                    PokemonResponse pokemonResponse =response.body();
                    ArrayList<Pokemon>pokemonArrayList = pokemonResponse.getResult();
                 pokemonListAdapter.addPokemonToList(pokemonArrayList);
                    }
                }


            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {

            }
        });
    }
}
