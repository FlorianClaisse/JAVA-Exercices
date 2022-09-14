package fr.florianclaisse.TD3;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Creation du robot et du drone
        //Position position = new Position(4,4);
        Vehicule[] vehicles = new Vehicule[]{
            new Robot(4, 4, 200, 2),
            new Drone(5, 5, 200, 1)
        };

        Sprite[] sprites = new Sprite[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Robot) {
                sprites[i] = new SpriteRobot((Robot) vehicles[i]);
            } else {
                sprites[i] = new SpriteDrone((Drone) vehicles[i]);
            }
        }

        // Affiche la fenetre
        View view = new View(20, 20);

        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);

            for (int i = 0; i < vehicles.length; i++) {
                if (!vehicles[i].getPosition().equals(target) && vehicles[i].canMove(target)) {
                    sprites[i].animateMove(target);
                    break;
                }
            }
        });

        view.getPane().getChildren().addAll(Arrays.stream(sprites).map(Sprite::getImg).toList());

        /*
        for (Sprite sprite : sprites) {
            view.getPane().getChildren().add(sprite.getImg());
        }*/
    }

    public static void main(String[] args) { launch(); }
}