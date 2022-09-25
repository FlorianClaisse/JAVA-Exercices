package fr.florianclaisse.TD5.Models;


public class GridRepoStringRLE implements GridRepo {

    private final char EOL = 'x';

    @Override
    public Grid load(String string) throws GridException {
        // Decompression
        StringBuilder array = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                array.append(String.valueOf(string.charAt(i - 1)).repeat(Math.max(0, Integer.parseInt(String.valueOf(string.charAt(i))) - 1)));
            } else {
                array.append(string.charAt(i));
            }
        }

        // Create Grid
        int height = (int) array.chars().filter(ch -> ch == this.EOL).count();
        int width = array.toString().indexOf(this.EOL);

        if (height <= 0 || width <= 0) throw new GridException("Missing EOL character");

        String[] strings = array.toString().split(String.valueOf(this.EOL));

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
        StringBuilder dest = new StringBuilder();
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                int runLength = 1;
                while (x + 1 < grid.getWidth() && grid.get(x, y) == grid.get(x + 1, y)) {
                    runLength++;
                    x++;
                }

                if (runLength <= 2) {
                    for (int i = 0; i < runLength; i++) dest.append(grid.get(x, y).getCode());
                } else {
                    dest.append(grid.get(x, y).getCode());
                    dest.append(runLength);
                }
            }
            dest.append(this.EOL);
        }

        System.out.println("G4DG4xG6DGGxGGRCGGBGGxGRGRG5xG9xG7CGxGDGDG5xG3CGDBGGxGRG7x");
        System.out.println(dest);

        return dest.toString();
    }
}
