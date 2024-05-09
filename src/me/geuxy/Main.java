package me.geuxy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import me.geuxy.pokemon.Pokemon;
import me.geuxy.pokemon.PokemonManager;

public class Main extends Application {

    private final Image ballImage = new Image("ball.gif", 256, 256, true, false);

    private Text text;
    private ImageView imageView;
    private TextField textField;

    private Pokemon pokemon;

    private int score;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        new PokemonManager().init();

        this.text = new Text("Score: " + score);

        this.imageView = new ImageView(ballImage);
        this.imageView.setSmooth(false);

        this.textField = new TextField();
        textField.setOnAction(e -> changePokemon());
        textField.setMinHeight(32);

        BorderPane pane = new BorderPane();
        pane.setTop(text);
        pane.setCenter(imageView);
        pane.setBottom(textField);

        // Setup Scene
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();



        // Move ImageView behind TextField
        imageView.toBack();

        // Setup Stage
        stage.setTitle("Pokemon Guesser");
        stage.widthProperty().addListener(e -> this.scaleWidth(stage.getWidth(), stage.getHeight()));
        stage.heightProperty().addListener(e -> this.scaleHeight(stage.getWidth(), stage.getHeight()));

        imageView.toBack();

        // Set Pokemon
        this.changePokemon();
    }

    private void scaleWidth(double w, double h) {
        double size = Math.min(w, h);

        this.imageView.setFitWidth(size);
        this.imageView.setLayoutX(w / 2 - (size / 2));
    }

    private void scaleHeight(double w, double h) {
        double size = Math.min(w, h);

        this.imageView.setFitHeight(size);
        this.imageView.setLayoutY(h / 2 - (size / 2) - textField.getHeight());
    }

    private void changePokemon() {
        String answer = this.textField.getText().toLowerCase().trim();

        if(pokemon != null) {
            if (answer.equals(pokemon.getName().toLowerCase())) {
                this.addScore();
            }
        }

        this.textField.setText("");

        this.pokemon = PokemonManager.getRandom();

        this.imageView.setImage(ballImage);

        new Thread(() -> {
            if (pokemon.getIcon() == null) {
                pokemon.setImage(getPokemonImage(pokemon));
            }

            this.imageView.setImage(pokemon.getIcon());
        }).start();
    }

    private Image getPokemonImage(Pokemon pokemon) {
        String rawURL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

        return new Image(rawURL + pokemon.getNumber() + ".png", 256, 256, true, false);
    }

    private void addScore() {
        this.text.setText("Score: " + ++score);
    }

}
