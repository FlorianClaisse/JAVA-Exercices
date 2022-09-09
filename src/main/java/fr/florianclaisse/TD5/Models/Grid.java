package fr.florianclaisse.TD5.Models;


public class Grid {

    private final int width;
    private final int height;
    private final Entity[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Entity[height][width];
    }

    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }

    public Entity get(int i, int j) { return this.grid[j][i]; }
    public void set(int i, int j, Entity entity) { this.grid[j][i] = entity; }
}
