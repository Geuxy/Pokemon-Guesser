package me.geuxy.pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.IOException;
import java.net.URL;

public class Pokemon {

    private final String name, number;
    private final Icon icon;

    public Pokemon(final String name, final String number) {
        this.name = name;
        this.number = number;
        this.icon = getIconByNumber();
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    private Icon getIconByNumber() {
        String pokedexImageLink = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/" + number + ".png";

        try {
            return new ImageIcon(ImageIO.read(new URL(pokedexImageLink)));
        } catch (IOException e) {
            System.err.println("Failed to get pokemon icon for '" + name + "': " + e.getCause());
        }

        return null;
    }

}
