package fr.florianclaisse.TD5.Views;


import fr.florianclaisse.TD5.Models.Entity;
import javafx.scene.image.Image;

public enum ImageResource {
    ROCK("rock.png"),
    GROUND("ground.png"),
    BIGROCK("bigRock.png"),
    CRACK("crack.png"),
    DUST("dust.png");

    public static final int size = 40;
    private final Image image;

    ImageResource(String file) { this.image = new Image(ImageResource.class.getResourceAsStream("/images/TD5/" + file)); }

    public static Image get(Entity kind) {
        if (kind != null)
            return ImageResource.valueOf(kind.toString()).image;
        return null;
    }
}
