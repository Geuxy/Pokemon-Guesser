package me.geuxy;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import me.geuxy.pokemon.PokemonManager;
import me.geuxy.scenes.GameScene;
import me.geuxy.scenes.HomeScene;

public class Main extends Application {

    private final Image ballImage = new Image("ball.gif", 256, 256, true, false);

    /*
     * Scenes
     */
    private HomeScene homeScene;
    private GameScene gameScene;

    /*
     * Main method
     */
    public static void main(String[] args) {
        launch(args);
    }

    /*
     * Setup Window
     */
    @Override
    public void start(Stage stage) {

        // Get all pokemon
        new PokemonManager();

        // Initialize Home Screen and set button click event
        this.homeScene = new HomeScene(mode -> {
            gameScene = new GameScene(homeScene.getWidth(), homeScene.getHeight(), mode);

            // Center scene elements when resized
            stage.widthProperty().addListener(e -> gameScene.scaleWidth(stage.getWidth(), stage.getHeight()));
            stage.heightProperty().addListener(e -> gameScene.scaleHeight(stage.getWidth(), stage.getHeight()));

            // Change scene to game
            stage.setScene(gameScene);
        });
        // Set default scene to Home Scene
        stage.setScene(homeScene);
        stage.setTitle("Pokemon Guesser");
        stage.getIcons().add(ballImage);
        stage.show();
    }

}
