package fr.florianclaisse.TD4.Models;

import fr.florianclaisse.TD4.Position;

public class World {

    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int DUST = 2;

    private final int map[][];

    public World(int width, int height) { this.map = new int[width][height]; }

    // TODO: Verifier le bonne ordre du tableau

    public int get(Position position) {
        if (position.getX() < map.length && position.getY() < map[0].length) {
            return this.map[position.getX()][position.getY()];
        }
        return -1;
    }

    public void set(Position position, int kind) {
        if (kind == EMPTY || kind == ROCK || kind == DUST) {
            this.map[position.getX()][position.getY()] = kind;
        }
    }
}
