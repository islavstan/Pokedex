package com.islavdroid.pokedex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by islav on 19.11.2016.
 */

public class Pokemon {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
private int number;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[]urlPartes = url.split("/");
        //"url": "http://pokeapi.co/api/v2/pokemon/3/" -картинка это цифра 3, получаем эту цифру
        return Integer.parseInt(urlPartes[urlPartes.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
