package me.geuxy.pokemon;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import me.geuxy.util.other.ScannerUtil;

import java.util.*;

public class PokemonManager {

    public static final List<Pokemon> pokedex = new ArrayList<>();

    public PokemonManager() {
        String pokedexUrl = "https://raw.githubusercontent.com/Purukitto/pokemon-data.json/master/pokedex.json";

        JsonArray json = new Gson().fromJson(ScannerUtil.scanURL(pokedexUrl), JsonArray.class);

        for(JsonElement pokemon : json) {
            pokedex.add(new Pokemon(pokemon));
        }
    }

    public static Pokemon random() {
        int index = (int) (Math.random() * pokedex.size());

        return pokedex.get(index);
    }

}
