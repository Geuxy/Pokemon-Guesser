package me.geuxy.pokemon;

import javafx.scene.image.Image;

public class Pokemon {

    private final String name, number;
    private Image icon;

    public Pokemon(final String name, final String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Image getIcon() {
        return icon;
    }

    public void setImage(Image icon) {
        this.icon = icon;
    }

    public String getNumber() {
        return number;
    }

}
