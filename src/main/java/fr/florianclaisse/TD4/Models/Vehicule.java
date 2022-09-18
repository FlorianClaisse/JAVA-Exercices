package fr.florianclaisse.TD4.Models;

public abstract class Vehicule {

    private Position position;
    private double energy;
    private final double cost;
    private boolean move = false;

    public Vehicule(Position position, double energy, double cost) {
        this.position = position;
        this.energy = energy;
        this.cost = cost;
    }

    public Vehicule(int posx, int posy, double energy, double cost) {
        this(new Position(posx, posy), energy, cost);
    }

    private int range() {
        return (int) (this.energy / this.cost);
    }

    public abstract int distance(Position target);

    public final boolean canMove(Position target) {
        return !this.move && this.distance(target) <= this.range();
    }

    public final void move(Position target) {
        this.energy -= this.distance(target) * this.cost;
        this.position = target;
        this.move = false;
        System.out.println("Move completed: " + this);
    }

    public abstract Position[] getPathTo(Position target);

    public final Position getPosition() { return this.position; }
    public final void setMove(boolean move) { this.move = move; }

    @Override
    public String toString() {
        String name;
        if (this instanceof Robot) { name = "Robot"; }
        else { name = "Drone"; }

        return name + "(energy=" + this.energy + ")";
    }
}
