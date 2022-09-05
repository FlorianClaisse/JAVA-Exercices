package fr.florianclaisse.TD4.Views;


import javafx.scene.image.ImageView;

public abstract class Sprite {

    private ImageView img;

    public Sprite(ImageView img) {
        this.img = img;
    }

    public final ImageView getImg() { return this.img; }
}
