package fr.florianclaisse.TD2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Creation du robot et du drone
        //Position position = new Position(4,4);
        Robot robot = new Robot(4, 4, 200, 2);
        SpriteRobot spriteRobot = new SpriteRobot(robot);

        // Affiche la fenetre
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            if (robot.canMove(target)) {
                spriteRobot.animateMove(target);
            }
        });

        view.getPane().getChildren().addAll(spriteRobot.getImg());

    }

    public static void main(String[] args) { launch(); }
}