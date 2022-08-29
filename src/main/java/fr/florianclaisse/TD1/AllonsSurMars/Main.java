package fr.florianclaisse.TD1.AllonsSurMars;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        // Affiche le robot
        /*ImageView img = new ImageView(new Image("./robot.png"));
        img.setX(100);
        img.setY(100);*/

        Robot robot = new Robot(new Position(100, 100), 400, 10);

        // Affiche la fenetre
        root.getChildren().addAll(robot.FXRobot(), robot.FXRayonAction());
        Scene scene = new Scene(root, 220, 220);
        scene.setFill(Color.rgb(241,199,128));
        stage.setTitle("POO - TD1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        TestPosition.test();
        TestRobot.tests();

        launch();
    }

    public static class TestPosition {
        static void test() {
            Position test = new Position(0, 0);
            test.afficher();
            test.deplacement(2, 4);
            test.afficher();
            test.deplacement(-1);
            test.afficher();
            System.out.println(test.distance(new Position(-4, -4)));
        }
    }

    public static class TestRobot {
        static void tests() {
            Robot test = new Robot(new Position(100, 100), 400, 10);
            test.afficher();
            System.out.println(test.rayonAction());
            System.out.println(test.peutSeDeplacer(new Position(120, 120)));
        }
    }
}
