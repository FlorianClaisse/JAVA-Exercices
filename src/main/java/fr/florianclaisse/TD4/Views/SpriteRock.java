package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Position;
import javafx.scene.image.ImageView;

public class SpriteRock extends SpriteDecor {

    public SpriteRock(Position position) {
        super(position, new ImageView(ImageResource.imageRock));
    }
}
