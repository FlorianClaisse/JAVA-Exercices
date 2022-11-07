package fr.florianclaisse.TD8;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point position) {
        this(position.x, position.y);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o instanceof Point position) {
            return position.x == this.x && position.y == this.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Point{x=" + x + ",y=" + y + "}";
    }
}