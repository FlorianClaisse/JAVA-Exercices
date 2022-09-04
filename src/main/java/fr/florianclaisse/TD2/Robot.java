package fr.florianclaisse.TD2;

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
    }

    public Position[] getPathTo(Position target) {
        // TODO: Trouver un code pour faire l'escalier
        Position[] array = new Position[2];
        array[0] = new Position(target.getX(), this.position.getY());
        array[1] = new Position(target.getX(), target.getY());

        return array;
    }

    public Position getPosition() { return this.position; }
    public void setMove(boolean move) { this.move = move; }
}
