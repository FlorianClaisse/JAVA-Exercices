package fr.florianclaisse.TD4;

import fr.florianclaisse.TD4.Models.Drone;
import fr.florianclaisse.TD4.Models.Robot;
import fr.florianclaisse.TD4.Models.Vehicule;
import fr.florianclaisse.TD4.Views.*;
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

        SpriteVehicule[] spriteVehicules = new SpriteVehicule[vehicules.length];
        for (int i = 0; i < vehicules.length; i++) {
            if (vehicules[i] instanceof Robot) { spriteVehicules[i] = new SpriteRobot( (Robot) vehicules[i]); }
            else { spriteVehicules[i] = new SpriteDrone( (Drone) vehicules[i]); }
        }

        SpriteDecor[] spriteDecors = new SpriteDecor[] {
            new SpriteDust(new Position(5, 15)),
            new SpriteDust(new Position(15, 2)),
            new SpriteRock(new Position(10, 3)),
            new SpriteRock(new Position(14, 14))
        };

        // Affiche la fenetre
        View view = new View(20, 20);

        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);

            for (int i = 0; i < vehicules.length; i++) {
                if (!vehicules[i].getPosition().equals(target) && vehicules[i].canMove(target)) {
                    spriteVehicules[i].animateMove(target);
                    break;
                }
            }
        });

        for (Sprite sprite: spriteVehicules) {
            view.getPane().getChildren().add(sprite.getImg());
        }

        for (Sprite sprite: spriteDecors) {
            view.getPane().getChildren().add(sprite.getImg());
        }


    }

    public static void main(String[] args) { launch(); }
}