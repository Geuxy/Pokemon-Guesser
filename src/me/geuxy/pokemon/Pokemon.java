package me.geuxy.pokemon;

import javax.swing.*;

public class Pokemon {

    private final String name, number;
    private Icon icon;

    public Pokemon(final String name, final String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getNumber() {
        return number;
    }

}
