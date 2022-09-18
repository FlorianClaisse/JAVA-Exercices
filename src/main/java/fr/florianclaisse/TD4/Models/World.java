package fr.florianclaisse.TD4.Models;

public class World {

    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int DUST = 2;

    private final int width;
    private final int height;
    private final int[][] map;

    public World(int width, int height) {
        this(width, height, 0, 100);
    }

    public World(int width, int height, int percentageRock, int percentageDust) {
        this.width = width;
        this.height = height;
        this.map = new int[height][width];

        this.createMap(World.DUST, percentageDust);
        this.createMap(World.ROCK, percentageRock);
    }

    private void createMap(int kind, int percentage) {
        int current = 0;
        int finish = (percentage * (this.width * this.height)) / 100;

        while (current != finish) {
            Position position = Position.random(this.width, this.height);
            if (this.get(position) == World.EMPTY) {
                this.set(position, kind);
                current++;
            }
        }
    }

    public int get(Position position) {
        return this.map[position.getY()][position.getX()];
    }

    public void set(Position position, int kind) {
        if (kind == EMPTY || kind == ROCK || kind == DUST) {
            this.map[position.getY()][position.getX()] = kind;
        }
    }

    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }
}
