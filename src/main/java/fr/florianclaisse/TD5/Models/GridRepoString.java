package fr.florianclaisse.TD5.Models;

public class GridRepoString implements GridRepo {

    private final char EOL = 'x';

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
}
