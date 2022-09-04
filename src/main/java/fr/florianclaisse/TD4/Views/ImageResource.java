package fr.florianclaisse.TD4.Views;


import javafx.scene.image.Image;

public class ImageResource {
    public static final int size = 40;
    public static final Image imageRobot = ImageResource.loadImage("robot.png");
    public static final Image imageDrone = ImageResource.loadImage("drone.png");

    public static final Image imageRock = ImageResource.loadImage("rock.png");
    public static final Image imageDust = ImageResource.loadImage("dust.png");

    private static Image loadImage(String file) {
        return new Image(ImageResource.class.getResourceAsStream("/images/" + file));
    }
}

