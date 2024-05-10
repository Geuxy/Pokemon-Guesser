package me.geuxy.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import me.geuxy.GuessMode;
import me.geuxy.util.function.Handler;

public class HomeScene extends Scene {

    private final Image ballImage = new Image("ball.gif", 256, 256, true, false);

    public HomeScene(Handler<GuessMode> action) {
        super(new GridPane(3, 3), 400, 500);

        GridPane root = (GridPane) this.getRoot();

        root.setAlignment(Pos.CENTER);

        Label label = new Label("Guess Mode");
        label.setFont(new Font("Arial", 30));

        ImageView imageView = new ImageView(ballImage);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        root.add(label, 0, 0);
        root.add(imageView, 1, 2);

        int col = 0;
        int row = 1;
        for(GuessMode mode : GuessMode.values()) {
            Button button = new Button(mode.name());
            button.setOnAction(e -> action.handle(mode));
            button.setPrefSize(200, 200);
            root.add(button, col, row);

            col++;

            if(col > 1) {
                col = 0;
                row++;
            }
        }
    }

}
