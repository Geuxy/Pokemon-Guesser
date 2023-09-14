package me.geuxy.pokemon;

import me.geuxy.pokemon.enums.EnumPokedex;

import java.util.*;

public class PokemonManager {

    public static final List<Pokemon> POKEDEX = new ArrayList<>();

    public PokemonManager init() {
        for(EnumPokedex pokemon : EnumPokedex.values()) {
            POKEDEX.add(pokemon.getPokemon());
        }

        return this;
    }

    public Pokemon getRandom() {
        int index = (int) (Math.random() * POKEDEX.size());

        return POKEDEX.get(index);
    }

}
