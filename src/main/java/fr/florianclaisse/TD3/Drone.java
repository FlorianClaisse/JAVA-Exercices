package fr.florianclaisse.TD3;

public class Drone extends Vehicule {

    public Drone(Position position, double energy, double cost) {
        super(position, energy, cost);
    }

    public Drone(int posx, int posy, double energy, double cost) {
        super(posx, posy, energy, cost);
    }

    @Override
    public int distance(Position target) {
        int x = this.getPosition().getX() - target.getX();
        int y = this.getPosition().getY() - target.getY();
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public Position[] getPathTo(Position target) {
        this.setMove(true);
        return new Position[] { target };
    }
}
