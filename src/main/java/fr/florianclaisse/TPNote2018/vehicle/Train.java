package fr.florianclaisse.TPNote2018;

public class Train extends Vehicle {

    public Train(String name, int passengers, int speed, int kmCost) {
        super(name, passengers, speed, kmCost);
    }

    @Override
    public boolean compatibleWith(City c) { return c.getStation(); }
}
