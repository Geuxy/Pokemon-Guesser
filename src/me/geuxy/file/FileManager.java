package me.geuxy.file;

import me.geuxy.pokemon.PokemonManager;
import me.geuxy.util.FileUtils;
import me.geuxy.util.ILogger;

import java.io.*;
import java.net.URL;

public class FileManager {

    public static final File FOLDER = new File(System.getProperty("user.home") + File.separator + "PokemonGuesser");

    public static void init() {
        if(FOLDER.exists()) {
            return;
        }

        FOLDER.mkdir();

        PokemonManager.POKEDEX.forEach(p -> {
            File file = new File(FOLDER, p.getName() + ".png");

            if(!file.exists()) {
                URL url;

                try {
                    url = new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/full/" + p.getNumber() + ".png");

                    FileUtils.downloadImage(url, file);
                    ILogger.log("Downloaded image: " + file.getPath());
                } catch (Exception e) {
                    ILogger.error("Failed to download image for '" + p.getName() + "'");
                }
            }

        });
    }

}
