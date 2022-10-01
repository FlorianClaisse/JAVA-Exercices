package fr.florianclaisse.TD6.Models;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public interface GridRepoIO {
    Grid load(Reader in) throws IOException;
    void export(Grid grid, Writer ou) throws IOException;
}
