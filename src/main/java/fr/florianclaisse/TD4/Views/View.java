package fr.florianclaisse.TD4.Views;

import fr.florianclaisse.TD4.Models.World;
import fr.florianclaisse.TD4.Models.Position;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class View {
    private final int width;
    private final int height;
    private final Pane pane;
    private Scene scene;

    public View(int width, int height) {
        this.pane = new Pane();

        this.scene = new Scene(pane);
        this.scene.setFill(Color.rgb(241,199,128));

        this.width = width;
        this.height = height;

        this.drawLines();
    }

    public View(World world) {
        this(world.getWidth(), world.getHeight());

        for (int y = 0; y < this.width; y++) {
            for (int x = 0; x < this.height; x++) {
                Position position = new Position(x, y);

                if (world.get(position) != World.EMPTY) {
                    this.pane.getChildren().add(DecorFactory.create(position, world.get(position)).getImg());
                }
            }
        }
    }

    private void drawLines() {

        for (int i = 1; i < this.width; i++) {
            int x = ImageResource.size * i;

            Line line = new Line(x, 0, x, ImageResource.size * this.height);
            line.setStroke(Color.GRAY);
            line.getStrokeDashArray().addAll(2d, 5d);

            pane.getChildren().add(line);
        }

        for (int j = 1; j < this.height; j++) {
            int y = ImageResource.size * j;

            Line line = new Line(0, y, ImageResource.size * this.width, y);
            line.getStrokeDashArray().addAll(2d, 5d);
            line.setStroke(Color.GRAY);

            pane.getChildren().add(line);
        }
    }

    /* Returns the position of the mouse in the grid */
    public Position getPosition(MouseEvent e) {
        int x = (int) e.getX() / ImageResource.size;
        int y = (int) e.getY() / ImageResource.size;

        return new Position(x, y);
    }

    public Pane getPane() { return this.pane; }
}
