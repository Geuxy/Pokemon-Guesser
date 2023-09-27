package me.geuxy.gui;

import me.geuxy.file.FileManager;
import me.geuxy.pokemon.PokemonManager;
import me.geuxy.util.ILogger;

import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadingScreen extends JFrame {

    public LoadingScreen() {
        this.setTitle("Pokemon Guesser - Splash");
        this.setSize(650, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        URL resource = ClassLoader.getSystemResource("loading.gif");

        JLabel label = new JLabel(new ImageIcon(resource));
        JLabel label2 = new JLabel("Loading Pokemon");
        label2.setPreferredSize(new Dimension(label2.getWidth(), 30));

        this.add(label);
        this.add(label2, BorderLayout.SOUTH);

        this.setVisible(true);

        new PokemonManager().init();

        label2.setText("Downloading assets");
        FileManager.init();

        label2.setText("Loading assets");
        this.loadAssets();
    }

    private void loadAssets() {
        PokemonManager.POKEDEX.forEach(p -> {
            try {
                File fileIcon = new File(FileManager.FOLDER, p.getName() + ".png");
                Icon icon = new ImageIcon(fileIcon.toURL());

                p.setIcon(icon);
                ILogger.log("Loaded asset: " + fileIcon.getPath());

            } catch (MalformedURLException e) {
                ILogger.error("Failed to load asset for '" + p.getName() + "'");
            }
        });
    }

}
