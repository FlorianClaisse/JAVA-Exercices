package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Models.Robot;
import javafx.scene.image.ImageView;

public class SpriteRobot extends SpriteVehicule {
    public SpriteRobot(Robot robot) {
        super(robot, new ImageView(ImageResource.imageRobot));
    }
}
