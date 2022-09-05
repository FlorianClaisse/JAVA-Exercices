package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Position;
import javafx.scene.image.ImageView;

public class SpriteDust extends SpriteDecor {

    public SpriteDust(Position position) {
        super(position, new ImageView(ImageResource.imageDust));
    }

}
