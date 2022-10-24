package fr.florianclaisse.TD6.Models;

import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

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
        try (in) {
            if (!in.ready()) throw new IOException("La lecture du fichier n'est pas possible");

            StringBuilder buffer = new StringBuilder();
            int currentChar = in.read();
            while (currentChar != -1) {
                buffer.append((char) currentChar);
                currentChar = in.read();
            }

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

        try (ou) {
            ou.write(dest);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Graph<Point> getGraph(Grid grid){
        Graph<Point> graph = new Graph<>();
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                if (grid.get(x, y).isAccessible()) {
                    graph.addNode(new Point(x, y));
                }
            }
        }

        Point pos = new Point();
        Point pos2 = new Point();

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                if (!grid.get(x, y).isAccessible()) continue;
                pos.setLocation(x, y);
                if (x > 0) {
                    pos2.setLocation(x - 1, y);
                    if (grid.get((int) pos2.getX(), (int) pos2.getY()).isAccessible()) {
                        graph.getNode(pos).addEdge(graph.getNode(pos2));
                    }
                } if (y > 0) {
                    pos2.setLocation(x, y - 1);
                    if (grid.get((int) pos2.getX(), (int) pos2.getY()).isAccessible()) {
                        graph.getNode(pos).addEdge(graph.getNode(pos2));
                    }
                } if (x < grid.getWidth() - 1) {
                    pos2.setLocation(x + 1, y);
                    if (grid.get((int) pos2.getX(), (int) pos2.getY()).isAccessible()) {
                        graph.getNode(pos).addEdge(graph.getNode(pos2));
                    }
                } if (y < grid.getHeight() - 1){
                    pos2.setLocation(x, y + 1);
                    if (grid.get((int) pos2.getX(), (int) pos2.getY()).isAccessible()) {
                        graph.getNode(pos).addEdge(graph.getNode(pos2));
                    }
                }
            }
        }

        return graph;
    }
}