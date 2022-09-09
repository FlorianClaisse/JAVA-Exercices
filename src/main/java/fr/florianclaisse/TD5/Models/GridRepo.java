package fr.florianclaisse.TD5.Models;

public interface GridRepo {
    Grid load(String string);
    String export(Grid grid);
}
