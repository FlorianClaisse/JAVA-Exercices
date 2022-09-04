package fr.florianclaisse.TD2;

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

    public int getX() { return this.x; }
    public int getY() { return this.y; }
}