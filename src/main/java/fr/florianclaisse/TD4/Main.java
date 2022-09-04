package fr.florianclaisse.TD4;

import fr.florianclaisse.TD4.Models.Drone;
import fr.florianclaisse.TD4.Models.Robot;
import fr.florianclaisse.TD4.Models.Vehicule;
import fr.florianclaisse.TD4.Views.Sprite;
import fr.florianclaisse.TD4.Views.SpriteDrone;
import fr.florianclaisse.TD4.Views.SpriteRobot;
import fr.florianclaisse.TD4.Views.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Creation du robot et du drone
        //Position position = new Position(4,4);
        Vehicule[] vehicules = new Vehicule[] {
            new Robot(4, 4, 200, 2),
            new Drone(5, 5, 200, 1)
        };

        Sprite[] sprites = new Sprite[vehicules.length];
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] instanceof Robot) { sprites[i] = new SpriteRobot( (Robot) vehicules[i]); }
            else { sprites[i] = new SpriteDrone( (Drone) vehicules[i]); }
        }

        // Affiche la fenetre
        View view = new View(20, 20);

        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);

            for (int i = 0; i < vehicules.length; i++) {
                if (!vehicules[i].getPosition().equals(target) && vehicules[i].canMove(target)) {
                    sprites[i].animateMove(target);
                    break;
                }
            }
        });

        for (Sprite sprite: sprites) {
            view.getPane().getChildren().add(sprite.getImg());
        }


    }

    public static void main(String[] args) { launch(); }
}