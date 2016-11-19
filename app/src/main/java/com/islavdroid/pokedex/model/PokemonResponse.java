package com.islavdroid.pokedex.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by islav on 19.11.2016.
 */

public class PokemonResponse {
    @SerializedName("results")
    private ArrayList<Pokemon> result;

    public ArrayList<Pokemon> getResult() {
        return result;
    }

    public void setResult(ArrayList<Pokemon> result) {
        this.result = result;
    }
}
