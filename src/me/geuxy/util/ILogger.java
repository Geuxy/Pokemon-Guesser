package me.geuxy.util;

public interface ILogger {

    static void log(Object object) {
        System.out.println("PokemonGuesser | INFO >> " + object);
    }

    static void error(Object object) {
        System.err.println("PokemonGuesser | ERROR >> " + object);
    }

}
