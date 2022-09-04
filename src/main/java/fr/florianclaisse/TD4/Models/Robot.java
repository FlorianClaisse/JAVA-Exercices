package fr.florianclaisse.TD4.Models;

import fr.florianclaisse.TD4.Position;

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
        // TODO: Trouver un code pour faire l'escalier
        Position[] array = new Position[2];
        array[0] = new Position(target.getX(), this.getPosition().getY());
        array[1] = new Position(target.getX(), target.getY());

        return array;
    }
}
