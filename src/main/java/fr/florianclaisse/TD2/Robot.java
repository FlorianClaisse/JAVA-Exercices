package fr.florianclaisse.TD2;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    private Position position;
    private double energy;
    private boolean move = false;
    private final double cost;

    public Robot(Position position, double energy, double cost) {
        this.position = position;
        this.energy = energy;
        this.cost = cost;
    }

    public Robot(int posx, int posy, double energy, double cost) {
        this(new Position(posx, posy), energy, cost);
    }

    private int range() {
        return (int) (this.energy / this.cost);
    }

    public int distance(Position target) {
        return Math.abs(target.getX() - this.position.getX()) + Math.abs(target.getY() - this.position.getY());
    }

    public boolean canMove(Position target) {
        return !this.move && this.distance(target) <= this.range();
    }

    public void move(Position target) {
        this.energy -= this.distance(target) * this.cost;
        this.position = target;
        this.move = false;
    }

    public Position[] getPathTo(Position target) {
        this.move = true;

        List<Position> posTab = new ArrayList<>();
        int x1 = position.getX(), x2 = target.getX();
        int y1 = position.getY(), y2 = target.getY();
        int distX = x2 - x1;
        int distY = y2 - y1;
        while (distX != 0 && distY != 0) {
            distX = x2 - x1;
            distY = y2 - y1;
            if (Math.abs(distX) > Math.abs(distY)) {
                if (distX > 0) { posTab.add(new Position(++x1, y1)); }
                else { posTab.add(new Position(--x1, y1)); }
            } else {
                if (distY > 0) { posTab.add(new Position(x1, ++y1)); }
                else { posTab.add(new Position(x1, --y1)); }
            }
        }
        return posTab.toArray(Position[]::new);
    }

    public Position getPosition() { return this.position; }
}
