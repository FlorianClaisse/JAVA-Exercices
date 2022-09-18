package fr.florianclaisse.TD4.Models;

import java.util.Objects;
import java.util.Random;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void translate(int delta) {
        this.translate(delta, delta);
    }

    public static Position random(int width, int height) {
        Random random = new Random();
        int r1 = random.nextInt(width);
        int r2 = random.nextInt(height);

        return new Position(r1, r2);
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}