package fr.florianclaisse.TD6.Views;

import fr.florianclaisse.TD6.Models.*;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class EditorView extends BorderPane {

    private final Stage stage;
    private Grid grid = new Grid(0,0);
    private final PickerView pickerView;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private final ClipboardContent clipboardContent = new ClipboardContent();

    public EditorView(Stage stage)  {
        this.stage = stage;
        GridRepo gridRepoVar = new GridRepoVar();
        GridRepoString gridRepoString = new GridRepoString();
        GridRepo gridRepoStringRLE = new GridRepoStringRLE();


        // Tile picker
        this.pickerView = new PickerView();
        this.setRight(pickerView);
        GridView gridView = new GridView(this.grid, this.pickerView);

        // Create menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        FileChooser fileChooser = new FileChooser();

        MenuItem marksItem = new MenuItem("Clear marks");
        marksItem.setOnAction(e -> gridView.getMarker().clear());

        MenuItem connectivityItem = new MenuItem("Check connectivity");
        editMenu.getItems().addAll(connectivityItem, marksItem);

        connectivityItem.setOnAction(e -> {
            if (gridRepoString.getGraph(this.grid).isConnected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Map is connected !!!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Map may be fully connected ???");
                alert.showAndWait();
            }
        });

        MenuItem newItem = new MenuItem("New map");
        MenuItem loadItemJ = new MenuItem("Load from Java declaration");
        MenuItem exportItemJ = new MenuItem("Export as Java declaration");
        MenuItem loadItemS = new MenuItem("Load from string");
        MenuItem loadItemF = new MenuItem("Load from file");
        MenuItem exportItemS = new MenuItem("Export as string");
        MenuItem exportItemF = new MenuItem("Export to file");
        MenuItem loadItemSZ = new MenuItem("Load from compressed string");
        MenuItem exportItemSZ = new MenuItem("Export as compressed string");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        fileMenu.getItems().addAll(
                newItem, new SeparatorMenuItem(),
                loadItemJ, exportItemJ, new SeparatorMenuItem(),
                loadItemS, exportItemS, new SeparatorMenuItem(),
                loadItemF, exportItemF, new SeparatorMenuItem(),
                loadItemSZ, exportItemSZ, new SeparatorMenuItem(),
                exitItem);
        menuBar.getMenus().addAll(fileMenu, editMenu);
        this.setTop(menuBar);

        // New empty map
        newItem.setOnAction(e -> {
            Form form = new Form(stage, "Size of the map : width x height");
            String[] parts = form.getText().replaceAll("\\s+","").split("x");
            if (parts.length != 2)
                return;
            try {
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                this.grid = gridRepoString.create(x, y);
                updateGrid(grid);
            } catch (NumberFormatException numberFormatException) {
                return;
            }
        });

        // Load from Java declarastion
        loadItemJ.setOnAction(e -> {
            Form form = new Form(stage, "Name field");
            this.grid = gridRepoVar.load(form.getText());
            this.updateGrid(this.grid);
        });

        // Export as Java declaration
        exportItemJ.setOnAction(e -> this.exportDialog(gridRepoVar.export(grid)));

        // Load from String
        loadItemS.setOnAction(e -> {
            Form form = new Form(stage, "Input string");
            this.grid = gridRepoString.load(form.getText());
            this.updateGrid(this.grid);
        });

        // Load from file
        loadItemF.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                try {
                    FileReader reader = new FileReader(file);
                    this.grid = gridRepoString.load(reader);
                    this.updateGrid(this.grid);
                } catch (IOException ex) { throw new RuntimeException(ex); }
            }
        });

        // Export as String
        exportItemS.setOnAction(e -> this.exportDialog(gridRepoString.export(this.grid)));

        // Export to file
        exportItemF.setOnAction(e -> {
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                try {
                    FileWriter writer = new FileWriter(file);
                    gridRepoString.export(this.grid, writer);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Load from compressed String
        loadItemSZ.setOnAction(e -> {
            Form form = new Form(stage, "Input compressed string");
            this.grid = gridRepoStringRLE.load(form.getText());
            updateGrid(grid);
        });

        // Export as compressed String
        exportItemSZ.setOnAction(e -> {
            exportDialog(gridRepoStringRLE.export(grid));
        });

        // Exit
        exitItem.setOnAction(e -> System.exit(0));
    }

    private void updateGrid(Grid grid) {
        if (grid != null) {
            Pane gridView = new GridView(grid, pickerView);
            this.setCenter(gridView);
            this.stage.sizeToScene();
        }
    }

    private void exportDialog(String msg) {
        this.clipboardContent.putString(msg);
        this.clipboard.setContent(this.clipboardContent);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Export");
        alert.setHeaderText("Saved to clipboard");
        alert.getDialogPane().setContent(new TextArea(msg));
        alert.setResizable(true);
        alert.showAndWait();
    }

}
