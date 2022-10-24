package fr.florianclaisse.TD6.Views;

import fr.florianclaisse.TD4.Models.Position;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class Marker {
    private final GridView gridView;
    private Circle marker;
    private Position position;

    public Marker(GridView gridView) {
        this.gridView = gridView;
    }

    public void clear() {
        if (marker != null)
            gridView.getChildren().remove(marker);
        marker = null;
    }

    public void create(Position position) {
        Circle marker = new Circle(position.getX() * ImageResource.size + ImageResource.size / 2, position.getY() * ImageResource.size + ImageResource.size / 2, 8, Color.TRANSPARENT);
        marker.setStroke(Color.BLUE);
        marker.setStrokeWidth(3);
        marker.setStrokeType(StrokeType.INSIDE);

        gridView.getChildren().add(marker);
        if (this.marker != null) {
            gridView.getChildren().remove(this.marker);
        }
        this.marker = marker;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean exists() {
        return marker != null;
    }
}