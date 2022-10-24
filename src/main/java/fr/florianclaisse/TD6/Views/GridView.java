package fr.florianclaisse.TD6.Views;

import fr.florianclaisse.TD4.Models.Position;
import fr.florianclaisse.TD6.Models.Grid;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.BorderPane;

public class GridView extends BorderPane {

    private final Grid grid;
    private final PickerView pickerView;
    private final Marker marker;

    public GridView(Grid grid, PickerView pickerView) {
        this.grid = grid;
        this.pickerView = pickerView;

        this.setPrefSize(grid.getWidth() * ImageResource.size, grid.getHeight() * ImageResource.size);
        this.marker = new Marker(this);

        for (int i = 0; i < this.grid.getWidth(); i++) {
            for (int j = 0; j < this.grid.getHeight(); j++) {
                this.createTile(i, j);
            }
        }
    }

    private void createTile(int i, int j) {
        int layoutX = i * ImageResource.size;
        int layoutY = j * ImageResource.size;

        Tile tile = new Tile(ImageResource.get(this.grid.get(i, j)), layoutX, layoutY);

        this.getChildren().add(tile);
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.2);
        tile.setOnMouseEntered(e -> {
            if (e.isShiftDown()) { update(tile, i, j); }
            tile.setEffect(colorAdjust);
        });
        tile.setOnMouseExited(e -> { tile.setEffect(null); });
        tile.setOnMouseClicked(e -> update(tile, i, j));
        tile.setOnContextMenuRequested(e -> {
            ContextMenu contextMenu = new ContextMenu();
            MenuItem itemMark = new MenuItem("Set mark");
            MenuItem itemPath = new MenuItem("Path finding");
            itemPath.setDisable(!marker.exists());
            // Put marker
            itemMark.setOnAction(event -> {
                marker.create(new Position(i, j));
            });
            // Path finding
            itemPath.setOnAction(event -> {
                System.out.println("Path finding " + marker.getPosition() + " -> " + new Position(i,j));
                // This needs to be updated!
                // Create the graph and run A* to find the shortest path
            });
            contextMenu.getItems().addAll(itemMark, itemPath);
            contextMenu.show(tile, e.getScreenX(), e.getScreenY());
        });
    }

    private void update(Tile tile, int i, int j) {
        if (this.pickerView.getSelected() != null && this.pickerView.getSelected() != this.grid.get(i, j)) {
            this.getChildren().remove(tile);
            this.grid.set(i, j, this.pickerView.getSelected());
            this.createTile(i, j);
        }
    }

    public Marker getMarker() { return this.marker; }
}
