package fr.florianclaisse.TD4.Models;

import java.util.ArrayList;
import java.util.List;

public class Robot extends Vehicule {

    public Robot(Position position, double energy, double cost) {
        super(position, energy, cost);
    }

    public Robot(int posx, int posy, double energy, double cost) {
        super(posx, posy, energy, cost);
    }

    @Override
    public int distance(Position target) {
        return Math.abs(target.getX() - this.getPosition().getX()) + Math.abs(target.getY() - this.getPosition().getY());
    }

    @Override
    public Position[] getPathTo(Position target) {
        this.setMove(true);

        List<Position> posTab = new ArrayList<>();
        int x1 = this.getPosition().getX(), x2 = target.getX();
        int y1 = this.getPosition().getY(), y2 = target.getY();
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
}
