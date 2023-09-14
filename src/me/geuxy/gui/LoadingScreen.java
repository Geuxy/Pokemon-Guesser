package me.geuxy.gui;

import javax.swing.*;

public class LoadingScreen extends JFrame {

    public LoadingScreen() {
        this.setTitle("Pokemon Guesser - Loading..");
        this.setSize(650, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("loading.gif"))));

        this.setVisible(true);
    }

}
