package fr.florianclaisse.TD6.Models;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class GridRepoString implements GridRepo, GridRepoIO {

    private final char EOL = 'x';

    public Grid create(int width, int height) {
        Grid grid = new Grid(width, height);
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                grid.set(x, y, Entity.GROUND);
            }
        }

        return grid;
    }

    @Override
    public Grid load(String string) throws GridException {
        int height = (int) string.chars().filter(ch -> ch == this.EOL).count();
        int width = string.indexOf(this.EOL);

        if (height <= 0 || width <= 0) throw new GridException("Missing EOL character");

        String[] strings = string.split(String.valueOf(this.EOL));

        Grid grid = new Grid(width, height);

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                try {
                    char entityCode = strings[y].charAt(x);
                    grid.set(x, y, Entity.fromCode(entityCode));
                } catch (IndexOutOfBoundsException e) {
                    throw new GridException("malformed string");
                }
            }
        }

        return grid;
    }

    @Override
    public Grid load(Reader in) throws IOException {
        try {
            if (!in.ready()) throw new IOException("La lecture du fichier n'est pas possible");

            StringBuilder buffer = new StringBuilder();
            int currentChar = in.read();
            while (currentChar != -1) {
                buffer.append((char) currentChar);
                currentChar = in.read();
            }

            in.close();

            return this.load(buffer.toString());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        } catch (GridException gridException) {
            System.out.println(gridException.getMessage());
        }

        return null;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder string = new StringBuilder();

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                string.append(grid.get(x, y).getCode());
            }
            string.append(this.EOL);
        }

        return string.toString();
    }

    @Override
    public void export(Grid grid, Writer ou) throws IOException {
        String dest = this.export(grid);

        try {
            ou.write(dest);
            ou.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
