package fr.florianclaisse.TD5.Views;

import fr.florianclaisse.TD5.Models.Grid;
import javafx.scene.layout.BorderPane;

public class GridView extends BorderPane {

    private final Grid grid;
    private final PickerView pickerView;

    public GridView(Grid grid, PickerView pickerView) {
        this.grid = grid;
        this.pickerView = pickerView;

        this.setPrefSize(grid.getWidth() * ImageResource.size, grid.getHeight() * ImageResource.size);

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

        tile.setOnMouseClicked(e -> update(tile, i, j));
        tile.setOnMouseEntered(e -> {
            if (e.isShiftDown()) { update(tile, i, j); }
        });
    }

    private void update(Tile tile, int i, int j) {
        if (this.pickerView.getSelected() != null && this.pickerView.getSelected() != this.grid.get(i, j)) {
            this.getChildren().remove(tile);
            this.grid.set(i, j, this.pickerView.getSelected());
            this.createTile(i, j);
        }
    }
}
