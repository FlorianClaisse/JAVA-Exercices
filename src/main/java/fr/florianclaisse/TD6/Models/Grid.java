package fr.florianclaisse.TD6.Models;


public class Grid {

    private final int width;
    private final int height;
    private final Entity[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Entity[height][width];
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < this.width && y < this.height;
    }

    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }

    public Entity get(int i, int j) { return this.grid[j][i]; }
    public void set(int i, int j, Entity entity) { this.grid[j][i] = entity; }
}
