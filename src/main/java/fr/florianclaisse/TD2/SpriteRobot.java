package fr.florianclaisse.TD2;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class SpriteRobot {
    private Robot robot;
    private ImageView img;

    public SpriteRobot(Robot robot) {
        this.robot = robot;

        img = new ImageView(ImageResource.imageRobot);

        this.updateLocation(robot.getPosition());
    }

    private void updateLocation(Position position) {
        this.img.setX(position.getX() * ImageResource.size);
        this.img.setY(position.getY() * ImageResource.size);
    }

    public void animateMove(Position target) {
        // Make the path movement
        Position[] positionPath = this.robot.getPathTo(target);

        this.robot.setMove(true);

        if (positionPath != null) {
            Path path = new Path();

            path.getElements().add(new MoveTo(this.robot.getPosition().getX() * ImageResource.size + ImageResource.size / 2,
                    this.robot.getPosition().getY() * ImageResource.size + ImageResource.size / 2));

            for (Position pos : positionPath) {
                path.getElements().add(new LineTo(pos.getX() * ImageResource.size + ImageResource.size / 2, pos.getY() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(300 * this.robot.distance(target)));
            ptr.setPath(path);
            ptr.setNode(this.getImg());
            ptr.play();

            ptr.setOnFinished(e -> {
                this.robot.move(target);
                this.robot.setMove(false);
            });
        } else {
            // Direct move
            this.robot.move(target);
            this.updateLocation(target);
            this.robot.setMove(false);
        }
    }

    public ImageView getImg() {
        return this.img;
    }
}
