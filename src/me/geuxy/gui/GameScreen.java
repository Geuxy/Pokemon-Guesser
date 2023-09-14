package me.geuxy.gui;

import me.geuxy.pokemon.Pokemon;
import me.geuxy.pokemon.PokemonManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JFrame implements KeyListener {

    // Managers
    private final PokemonManager pokemonManager = new PokemonManager().init();

    // Stuff
    private Pokemon pokemon = pokemonManager.getRandom();
    private int points;

    // Components
    private final JLabel imageLabel = new JLabel(pokemon.getIcon());
    private final JLabel scoreLabel = new JLabel("Score: 0");
    private final JTextField nameField = new JTextField();

    private final Font font = new Font("Arial", Font.PLAIN, 20);

    public GameScreen(LoadingScreen loadingScreen) {
        this.setTitle("Pokemon Guesser");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(650, 600);
        this.setMinimumSize(new Dimension(350, 350));
        this.setLocationRelativeTo(null);

        scoreLabel.setFont(font);

        nameField.setPreferredSize(new Dimension(nameField.getWidth(), 30));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setFont(font);
        nameField.addKeyListener(this);

        this.add(imageLabel);
        this.add(scoreLabel, BorderLayout.NORTH);
        this.add(nameField, BorderLayout.SOUTH);

        this.setVisible(true);

        loadingScreen.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (nameField.getText().equalsIgnoreCase(pokemon.getName())) {
                this.scoreLabel.setText("Score: " + ++points);
                this.nameField.setText("");

                this.pokemon = pokemonManager.getRandom();

                try {
                    this.imageLabel.setIcon(pokemon.getIcon());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}
