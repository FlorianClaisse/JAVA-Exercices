package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Models.Drone;
import javafx.scene.image.ImageView;

public class SpriteDrone extends SpriteVehicule {
    public SpriteDrone(Drone drone) {
        super(drone, new ImageView(ImageResource.imageDrone));
    }
}
