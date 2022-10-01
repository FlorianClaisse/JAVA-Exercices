package fr.florianclaisse.TD6;

import fr.florianclaisse.TD6.Models.GridRepoStringRLE;
import fr.florianclaisse.TD6.Views.EditorView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        EditorView editorView = new EditorView(stage);
        Scene scene = new Scene(editorView);
        stage.setTitle("Mars map editor");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        new GridRepoStringRLE().load("G4DG4xG6DGGxGGRCGGBGGxGRGRG5xG9xG7CGxGDGDG5xG3CGDBGGxGRG7x");
        launch();
    }
}