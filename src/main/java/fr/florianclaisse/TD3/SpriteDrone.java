package fr.florianclaisse.TD3;

import javafx.scene.image.ImageView;

public class SpriteDrone extends Sprite {
    public SpriteDrone(Drone drone) {
        super(drone, new ImageView(ImageResource.imageDrone));
    }
}
