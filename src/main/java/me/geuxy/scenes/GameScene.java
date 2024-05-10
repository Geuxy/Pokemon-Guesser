package me.geuxy.scenes;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import me.geuxy.GuessMode;
import me.geuxy.pokemon.Pokemon;
import me.geuxy.pokemon.PokemonManager;
import me.geuxy.util.type.IntegerUtil;

public class GameScene extends Scene {

    private final Image ballImage = new Image("ball.gif", 256, 256, true, false);

    private final Text text;
    private final ImageView imageView;
    private final TextField textField;

    private Pokemon pokemon;

    private int score;

    private GuessMode mode;

    public GameScene(double w, double h, GuessMode mode) {
        super(new BorderPane(), w, h);
        this.mode = mode;

        BorderPane root = (BorderPane) this.getRoot();

        this.text = new Text("Score: " + score);

        this.imageView = new ImageView(ballImage);
        this.imageView.setSmooth(false);

        this.textField = new TextField();
        this.textField.setOnAction(e -> changePokemon());
        this.textField.setMinHeight(32);

        root.setTop(text);
        root.setCenter(imageView);
        root.setBottom(textField);

        this.imageView.toBack();

        this.scaleWidth(root.getWidth(), root.getHeight());
        this.scaleHeight(root.getWidth(), root.getHeight());

        this.changePokemon();
    }

    public void scaleWidth(double w, double h) {
        double size = Math.min(w, h);

        this.imageView.setFitWidth(size);
        this.imageView.setLayoutX(w / 2 - (size / 2));
    }

    public void scaleHeight(double w, double h) {
        double size = Math.min(w, h);

        this.imageView.setFitHeight(size);
        this.imageView.setLayoutY(h / 2 - (size / 2) - textField.getHeight());
    }

    private void changePokemon() {
        if(pokemon != null && isAnswerCorrect()) {
            this.addScore();
        }

        this.textField.setText("");

        this.pokemon = PokemonManager.random();

        this.imageView.setImage(ballImage);

        new Thread(() -> {
            if (pokemon.getSprite() == null) {
                pokemon.setSprite();
            }

            this.imageView.setImage(pokemon.getSprite());
        }).start();
    }

    private boolean isAnswerCorrect() {
        String answer = this.textField.getText().toLowerCase().trim();

        return switch(mode) {
            case NAME -> this.pokemon.getName().toLowerCase().equals(answer);
            case NUMBER -> this.pokemon.getNumber() == IntegerUtil.toInt(answer);
            case ELEMENT -> this.pokemon.isType(answer.toLowerCase());
        };
    }

    private void addScore() {
        this.text.setText("Score: " + ++score);
    }

}
