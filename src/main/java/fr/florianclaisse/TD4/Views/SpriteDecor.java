package fr.florianclaisse.TD4.Views;


import fr.florianclaisse.TD4.Position;
import javafx.scene.image.ImageView;

public class SpriteDecor extends Sprite {

    private Position position;

    public SpriteDecor(Position position, ImageView img) {
        super(img);
        this.position = position;

        this.updateLocation(position);
    }

    private void updateLocation(Position position) {
        this.getImg().setX(position.getX() * ImageResource.size);
        this.getImg().setY(position.getY() * ImageResource.size);
    }
}
