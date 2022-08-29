package fr.florianclaisse.TD1.AllonsSurMars;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Robot {
    Position position;
    double energie;
    double cout;

    private final double size = 20;

    Robot(Position position, double energie, double cout) {
        this.position = position;
        this.energie = energie;
        this.cout = cout;
    }

    ImageView FXRobot() {
        ImageView robot = new ImageView(new Image("./robot.png"));
        robot.setX(this.position.x);
        robot.setY(this.position.y);

        return robot;
    }

    Circle FXRayonAction() {
        Circle circle = new Circle(this.position.x + this.size, this.position.y + this.size, this.rayonAction());
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);
        return circle;
    }

    double rayonAction() {
        return energie / cout;
    }

    boolean peutSeDeplacer(Position cible) {
        return this.position.distance(cible) <= this.rayonAction();
    }

    void afficher() {
        System.out.println("Robot{" + "position=" + position + ", energie=" + energie + ", cout=" + cout + '}');
    }
}
