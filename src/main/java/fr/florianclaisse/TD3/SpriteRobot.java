package fr.florianclaisse.TD3;

import javafx.scene.image.ImageView;

public class SpriteRobot extends Sprite {
    public SpriteRobot(Robot robot) {
        super(robot, new ImageView(ImageResource.imageRobot));
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
