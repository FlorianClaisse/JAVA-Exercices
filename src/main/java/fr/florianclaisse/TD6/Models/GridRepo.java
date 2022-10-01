package fr.florianclaisse.TD6.Models;

public interface GridRepo {
    Grid load(String string);
    String export(Grid grid);
}
