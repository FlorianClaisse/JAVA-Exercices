package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Models.Vehicule;
import fr.florianclaisse.TD4.Position;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class SpriteVehicule extends Sprite {

    private Vehicule vehicule;

    public SpriteVehicule(Vehicule vehicule, ImageView img) {
        super(img);
        this.vehicule = vehicule;

        this.updateLocation(vehicule.getPosition());
    }

    private void updateLocation(Position position) {
        this.getImg().setX(position.getX() * ImageResource.size);
        this.getImg().setY(position.getY() * ImageResource.size);
    }

    public final void animateMove(Position target) {
        // Make the path movement
        Position[] positionPath = this.vehicule.getPathTo(target);

        this.vehicule.setMove(true);

        if (positionPath != null) {
            Path path = new Path();

            path.getElements().add(new MoveTo(this.vehicule.getPosition().getX() * ImageResource.size + ImageResource.size / 2,
                    this.vehicule.getPosition().getY() * ImageResource.size + ImageResource.size / 2));

            for (Position pos : positionPath) {
                path.getElements().add(new LineTo(pos.getX() * ImageResource.size + ImageResource.size / 2, pos.getY() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(300 * this.vehicule.distance(target)));
            ptr.setPath(path);
            ptr.setNode(this.getImg());
            ptr.play();

            ptr.setOnFinished(e -> {
                this.vehicule.move(target);
                this.vehicule.setMove(false);
            });
        } else {
            // Direct move
            this.vehicule.move(target);
            this.updateLocation(target);
            this.vehicule.setMove(false);
        }
    }
}
